package com.f.piechowiak.spring.OddamWDobreRece.web.controllers;

import com.f.piechowiak.spring.OddamWDobreRece.core.UserService;
import com.f.piechowiak.spring.OddamWDobreRece.dto.RegistrationFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.dto.UserFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.email.EmailSender;
import com.f.piechowiak.spring.OddamWDobreRece.models.Charity;
import com.f.piechowiak.spring.OddamWDobreRece.models.User;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.CharityRepository;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Controller
@RequestMapping("/")
public class HomepageController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    HttpSession session;
    @Autowired
    CharityRepository charityRepository;
    @Autowired
    UserService userService;
    @Autowired
    EmailSender emailSender;


    @GetMapping
    public String getHomepage(Principal principal, Model model){
        if (principal != null){
            if (session.getAttribute( "userId" )==null){
                String userEmail = principal.getName();
                Long userId = userRepository.findByEmail( userEmail ).getId();
                System.err.println( "Wstawilem do sesji userId: "+ userId );
                boolean enabled = userRepository.findByEmail( userEmail ).isEnabled();
                if (enabled != true){
                    if(session != null)
                        session.invalidate();

                    return "redirect:/login";
                }
                String firstName = userRepository.findByEmail(userEmail).getFirstName();
                model.addAttribute( "userFirstName", firstName );
                session.setAttribute( "userFirstName", firstName );
                session.setAttribute( "userId", userId );
            }
        }
        return "homepage";

    }

    @GetMapping("/orgList")
    public String publicOrgList(Model model){
        List<Charity> organizationList = charityRepository.findAll();
        model.addAttribute( "organizationList", organizationList );
        return "charity/charityList";
    }

    @GetMapping("/contact")
    public String contactView(){
        return "contact";
    }

    @GetMapping("/forgotPassword")
    public String forgotPasswordPage (Model model){

        model.addAttribute( "passwordReset", new UserFormDto() );
        return "forgotPassword";
    }

    @PostMapping("/forgotPassword")
    public String forgotPasswordForm (@ModelAttribute ("passwordReset") @Valid UserFormDto form, BindingResult result, HttpServletRequest request){
        if (result.hasErrors()) {
            return "forgotPassword";
        }
        User user =  userService.findUserByEmail(form.getEmail());
        String emailAddress = form.getEmail();
        if (user != null) {
            String token = UUID.randomUUID().toString();
            userService.createPasswordResetTokenForUser(user, token);
            emailSender.sendEmail( emailAddress, "OddamWDobreRece - Reset Hasła "+ form.getEmail(), constructResetTokenEmail( getAppUrl(request), user, token ) );
            return "redirect:/login";
        } else {
            result.rejectValue( "email", null, "Cos poszlo nietak przy wpisywaniu Twojego adresu email, sprobuj jeszcze raz:)" );
            return "forgotPassword";
        }
    }

    /*private SimpleMailMessage constructResetTokenEmail(
            String contextPath, Locale locale, String token, User user) {
        String url = contextPath + "/user/changePassword?id=" +
                user.getId() + "&token=" + token;
        String message = messages.getMessage("message.resetPassword",
                null, locale);
        return constructEmail("Reset Password", message + " \r\n" + url, user);
    }*/

    private String constructResetTokenEmail(String contextPath, User user, String token){
        StringBuilder sb = new StringBuilder(  );
        sb.append( "Witaj <b>" )
                .append( user.getFirstName() )
                .append( "</b>, <br><br>" )
                .append( "Czy zapomniałeś swojego hasła i chcesz je teraz zrestartować? " )
                .append( "OddamWDobreRece umożliwi Tobie zmianę hasła w kilu prostych krokach." ).append( "<br>" )
                .append( "Jeśli to nie Ty wysłałeś prośbę o zmianę hasła zignoruj ninejszą wiadomość. " ).append( "<br>" )
                .append( "Możesz skorzystać z poniższego linka i przejść bezpośrednio do strony resetu hasła!" ).append( "<br>" )
                .append( contextPath ).append( "/user/changePassword?id=" ).append( user.getId() ).append( "&token=" ).append( token )
                .append( "<br>" )
                .append( "Pozdrawiamy :)" ).append( "<br>" )
                .append( "Zespół OddamWDobreRece.pl" );

        return sb.toString();

    }

    private String getAppUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

}
