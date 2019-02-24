package com.f.piechowiak.spring.OddamWDobreRece.web.controllers;

import com.f.piechowiak.spring.OddamWDobreRece.core.UserService;
import com.f.piechowiak.spring.OddamWDobreRece.dto.UserPasswordFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.models.User;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.UserRepository;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    HttpSession session;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/dashboard")
    public String prepareUserDashboard(Model model, Principal principal) {
        User user = userRepository.findByEmail( principal.getName() );
        model.addAttribute( "LoggedUser", user );
        return "userDashboard";
    }

    @GetMapping("/settings")
    public String prepareUserSettingsPage(Model model, Principal principal) {
        User user = userRepository.findByEmail( principal.getName() );
        model.addAttribute( "LoggedUser", user );
        return "userSettings";
    }


    @GetMapping("/changePassword")
    public String changeUserPasswordForm(Model model, Principal principal) {
        User user = userRepository.findByEmail( principal.getName() );
        model.addAttribute( "LoggedUser", user );
        model.addAttribute( "userToEdit", userService.findUserByIdAndFillToEditPassword( user.getId() ) );

        return "userChangePassword";
    }
    @PostMapping("/changePassword")
    public String changeUserPassword(@ModelAttribute("userToEdit") @Valid UserPasswordFormDto form, BindingResult result){
        if (result.hasErrors()) {
            return "/user/settings";
        }
        boolean success = userService.changeUserPassword( form );
        if (success) {
            return "redirect:/user/dashboard";
        } else {
            result.rejectValue( "password", null, "Cos poszło źle, spróbuj jeszcze raz" );
            return "/user/changePassword";
        }
    }


    @GetMapping("/confirmDeleteUserAccount")
    public String confirmDeleteUserAccount(Model model, Principal principal) {
        User user = userRepository.findByEmail( principal.getName() );
        model.addAttribute( "LoggedUser", user );
        return "userDeleteAccount";
    }
    @GetMapping("/deleteUser")
    public String deleteUser(Principal principal) {
        User user = userRepository.findByEmail( principal.getName() );
        System.err.println( "User do usunieńcia: " + user.getFirstName() );
        if (user != null) {
            userRepository.delete( user );
            if (session != null)
                session.invalidate();
            return "redirect:/login";
        }
        return "redirect:/user/settings";
    }


}
