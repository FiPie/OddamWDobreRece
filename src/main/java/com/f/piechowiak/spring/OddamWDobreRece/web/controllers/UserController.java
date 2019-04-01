package com.f.piechowiak.spring.OddamWDobreRece.web.controllers;

import com.f.piechowiak.spring.OddamWDobreRece.core.DonationService;
import com.f.piechowiak.spring.OddamWDobreRece.core.UserService;
import com.f.piechowiak.spring.OddamWDobreRece.dto.DonationDto;
import com.f.piechowiak.spring.OddamWDobreRece.dto.UserFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.dto.UserPasswordFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.models.Donation;
import com.f.piechowiak.spring.OddamWDobreRece.models.User;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.DonationRepository;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.UserRepository;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

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
    DonationRepository donationRepository;
    @Autowired
    private UserService userService;
    @Autowired
    DonationService donationService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/dashboard")
    public String prepareUserDashboard(Model model, Principal principal) {
        User user = userRepository.findByEmail( principal.getName() );
        String firstName = user.getFirstName();
        session.setAttribute( "userFirstName", firstName );
        model.addAttribute( "LoggedUser", user );

        Long bagsQuantity = donationRepository.sumBagsQuantityForUserId( user.getId() );
        model.addAttribute( "bagsQuantity", bagsQuantity );
        Long supportedCharitiesQuantity = donationRepository.sumOfSupportedCharitiesByUserId( user.getId() );
        model.addAttribute( "supportedCharitiesQuantity", supportedCharitiesQuantity );
        Long donationsQuantity = donationRepository.sumOfDonationsMadeByUserId( user.getId() );
        model.addAttribute( "donationsQuantity", donationsQuantity );

        return "user/userDashboard";
    }

    @GetMapping("/listOfDonations")
    public String prepareUserListOfDonations(Model model, Principal principal) {
        User user = userRepository.findByEmail( principal.getName() );
        model.addAttribute( "user", user );
        Long userId = user.getId();

        List<Donation> userDonations = donationRepository.findAllDonationsByUserId( userId );
        model.addAttribute( "userDonations", userDonations );

        return "user/userDonationsList";
    }

    @GetMapping("/donationDetails{id:[1-9]*[0-9]+}")
    public String userDonationDetails(@PathVariable Long id, Model model, Principal principal) {
        Donation donation = donationRepository.findById( id ).orElse( null );
        model.addAttribute( "donation", donation );
        User user = userRepository.findByEmail( principal.getName() );
        model.addAttribute( "user", user );
        DonationDto donationDto = new DonationDto();
        donationDto.setId( id );
        model.addAttribute( "donationDto", donationDto );

        return "user/userDonationDetails";
    }

    @PostMapping("/donationDetails")
    public String userDonationDeliveryStatusChange(@ModelAttribute("donationDto") @Valid DonationDto form, BindingResult result){

        boolean success = donationService.updateDonationDeliveryStatus( form );
        if (success){
            return "redirect:/user/donationDetails"+form.getId();
        }
        else {
            result.rejectValue( "giftPickedUp", null, "Something wrong with delivery status" );
        }
        return "user/donationDetails"+form.getId();
    }


    @GetMapping("/settings")
    public String prepareUserSettingsPage(Model model, Principal principal) {
        User user = userRepository.findByEmail( principal.getName() );
        model.addAttribute( "LoggedUser", user );
        return "user/userSettings";
    }


    @GetMapping("/changePassword")
    public String changeUserPasswordForm(Model model, Principal principal) {
        User user = userRepository.findByEmail( principal.getName() );
        model.addAttribute( "LoggedUser", user );
        model.addAttribute( "userToEdit", userService.findUserByIdAndFillToEditPassword( user.getId() ) );
        return "user/userChangePassword";
    }

    @PostMapping("/changePassword")
    public String changeUserPassword(@ModelAttribute("userToEdit") @Valid UserPasswordFormDto form, BindingResult result, Model model, Principal principal) {
        User user = userRepository.findByEmail( principal.getName() );
        model.addAttribute( "LoggedUser", user );
        model.addAttribute( "userToEdit", userService.findUserByIdAndFillToEditPassword( user.getId() ) );
        if (result.hasErrors()) {
            return "/user/settings";
        }
        boolean success = userService.changeUserPassword( form );
        if (success) {
            return "redirect:/user/dashboard";
        } else {
            result.rejectValue( "confirmedPassword", null, "Podane hasła nie są tożsame!" );
            return "user/userChangePassword";
        }
    }


    @GetMapping("/confirmDeleteUserAccount")
    public String confirmDeleteUserAccount(Model model, Principal principal) {
        User user = userRepository.findByEmail( principal.getName() );
        model.addAttribute( "LoggedUser", user );
        return "user/userDeleteAccount";
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

    @GetMapping("/editUser")
    public String prepareUserEditForm(Model model, Principal principal) {
        User user = userRepository.findByEmail( principal.getName() );
        model.addAttribute( "userToEdit", userService.findUserByIdAndFill( user.getId() ) );
        if (user == null) {
            return "redirect:/user/settings";
        }
        model.addAttribute( "toEdit", user );
        return "user/userEdit";
    }

    @PostMapping("/editUser")
    public String saveUserEdit(@ModelAttribute("userToEdit") @Valid UserFormDto form, BindingResult result) {
        if (result.hasErrors()) {
            return "user/settings";
        }
        boolean success = userService.updateUserByUser( form );
        if (success) {
            return "redirect:/user/dashboard";
        } else {
            result.rejectValue( "email", null, "Cos poszło źle, spróbuj jeszcze raz" );
            return "admin/adminUserEdit";
        }

    }


}
