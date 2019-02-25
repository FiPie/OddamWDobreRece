package com.f.piechowiak.spring.OddamWDobreRece.web.controllers;

import com.f.piechowiak.spring.OddamWDobreRece.core.AdminService;
import com.f.piechowiak.spring.OddamWDobreRece.core.CharityService;
import com.f.piechowiak.spring.OddamWDobreRece.core.RegistrationService;
import com.f.piechowiak.spring.OddamWDobreRece.core.UserService;
import com.f.piechowiak.spring.OddamWDobreRece.dto.*;
import com.f.piechowiak.spring.OddamWDobreRece.models.Charity;
import com.f.piechowiak.spring.OddamWDobreRece.models.User;
import com.f.piechowiak.spring.OddamWDobreRece.models.UserRole;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.AdminRepository;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.CharityRepository;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.UserRepository;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    HttpSession session;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    CharityRepository charityRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private CharityService charityService;



    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/dashboard")
    public String prepareAdminDashboard(Model model, Principal principal) {
        String firstName = userRepository.findByEmail(principal.getName()).getFirstName();
        session.setAttribute( "userFirstName", firstName );
        int numberOfUsers = userRepository.getUserList().size();
        int numberOfAdmins = userRepository.getAdminList().size();
        model.addAttribute( "userNumber", numberOfUsers );
        model.addAttribute( "adminNumber", numberOfAdmins);

        return "adminDashboard";
    }


    @GetMapping("/userList")
    public String prepareUserListForm() {
        List<User> userList = userRepository.getUserList();
        session.setAttribute( "userList", userList );
        return "userList";
    }


    @GetMapping("/adminList")
    public String prepareAdminListForm() {
        List<User> adminList = userRepository.getAdminList();
        session.setAttribute( "adminList", adminList );
        return "adminList";
    }


    @GetMapping("/orgList")
    public String prepareOrganizationListView(Model model) {
        List<Charity> organizationList = charityRepository.getCharityList();
        model.addAttribute( "organizationList", organizationList );
        return "orgList";
    }

    @GetMapping("/organizationForm")
    public String prepareOrganizationForm(Model model){
        model.addAttribute( "orgForm", new OrgFormDto() );
        return "orgForm";
    }
    @PostMapping("/organizationForm")
    public String createOrganization(@ModelAttribute("orgForm") @Valid OrgFormDto form, BindingResult result){
        if (result.hasErrors()) {
            return "/organizationForm";
        }
        boolean success = charityService.createOrganization( form );
        if (success) {
            return "redirect:/admin/orgList";
        } else {
            result.rejectValue( "charityName", null, "Cos poszlo nietak przy wpisywaniu danych w formularzu dodawania organizacji, sprobuj jeszcze raz:)" );
            return "/organizationForm";
        }
    }
    @GetMapping("/{id:[1-9]*[0-9]+}/confirmDeleteOrganization")
    public String confirmDeleteOrganization(@PathVariable Long id, Model model){
        Charity org = charityRepository.findById( id ).orElse( null );
        if (org == null) {
            return "redirect:/admin/orgList";
        }
        model.addAttribute( "toRemove", org );
        return "deleteOrg";
    }
    @GetMapping("/{id:[1-9]*[0-9]+}/deleteOrg")
    public String deleteOrganization(@PathVariable Long id) {
        Charity org = charityRepository.findById( id ).orElse( null );
        System.err.println( "Charity do usunieńcia: " + org.getCharityName() );
        if (org != null) { charityService.delete( org.getId() );}
        return "redirect:/admin/orgList";
    }




    @GetMapping("/giftList")
    public String prepareGiftListForm(Model model) {
        model.addAttribute( "AdminFormDto", new AdminFormDto() );
        return "giftList";
    }


    @GetMapping("/adminForm")
    public String prepareAdminForm(Model model) {
        model.addAttribute( "adminForm", new AdminFormDto() );
        return "adminForm";
    }

    @PostMapping("/adminForm")
    public String createNewAdmin(@ModelAttribute("adminForm") @Valid AdminFormDto form, BindingResult result) {
        if (result.hasErrors()) {
            return "/adminForm";
        }
        boolean success = userService.createAdmin( form );
        if (success) {
            return "redirect:/admin/adminList";
        } else {
            result.rejectValue( "email", null, "Cos poszlo nietak przy wpisywaniu danych w formularzu tworzenia admina, sprobuj jeszcze raz:)" );
            return "/adminForm";
        }
    }


    @GetMapping("/{id:[1-9]*[0-9]+}/confirmDeleteAdmin")
    public String confirmDeleteAdmin(@PathVariable Long id, Model model) {
        User user = userRepository.findById( id ).orElse( null );
        if (user == null) {
            return "redirect:/admin/adminList";
        }
        model.addAttribute( "toRemove", user );
        return "/deleteAdmin";
    }
    @GetMapping("/{id:[1-9]*[0-9]+}/deleteAdmin")
    public String deleteAdmin(@PathVariable Long id, Principal principal) {
        int adminListSize = userRepository.getAdminList().size();
        User user = userRepository.findById( id ).orElse( null );

        if (adminListSize < 2) {
            System.err.println("Nie możesz usunąć "+user.getFirstName()+" ponieważ wygląda na to, że jest to ostatni Admin w serwisie!");
            return "redirect:/admin/adminList";
        }

        User loggedUser = userRepository.findByEmail( principal.getName() );
        System.err.println( "Admin do usunieńcia: " + user.getFirstName() );

        if (user != null) {
            if (user.equals( loggedUser )) {
                System.err.println("Nie możesz usunąć sam siebie "+user.getFirstName()+"!");
                return "redirect:/admin/adminList";}
            else {userService.delete( user.getId() );}
        }
        return "redirect:/admin/adminList";
    }

    @GetMapping("/{id:[1-9]*[0-9]+}/editAdmin")
    public String prepareEditAdminForm(@PathVariable Long id, Model model) {
        model.addAttribute( "adminToEdit", userService.findAdminByIdAndFill( id ) );
        User user = userRepository.findById( id ).orElse( null );
        if (user == null) {
            return "redirect:/adminList";
        }
        model.addAttribute( "toEdit", user );

        return "/editAdmin";
    }
    @PostMapping("/editAdmin")
    public String saveEditAdminChanges(@ModelAttribute("adminToEdit") @Valid AdminFormDto form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/admin/adminList";
        }
        boolean success = userService.updateAdmin( form );
        if (success) {
            return "redirect:/admin/adminList";
        } else {
            result.rejectValue( "email", null, "Cos poszło źle, spróbuj jeszcze raz" );
            return "/" + form.getId() + "/editAdmin";
        }
    }




    @GetMapping("/{id:[1-9]*[0-9]+}/confirmDeleteUser")
    public String confirmDeleteUser(@PathVariable Long id, Model model) {
        User user = userRepository.findById( id ).orElse( null );
        if (user == null) {
            return "redirect:/admin/userList";
        }
        model.addAttribute( "toRemove", user );
        return "/deleteUser";
    }
    @GetMapping("/{id:[1-9]*[0-9]+}/deleteUser")
    public String deleteUser(@PathVariable Long id, Principal principal) {
        User user = userRepository.findById( id ).orElse( null );
        System.err.println( "User do usunieńcia: " + user.getFirstName() );
        if (user != null) {
            userService.delete( user.getId() );
        }
        return "redirect:/admin/userList";
    }

    @GetMapping("/{id:[1-9]*[0-9]+}/editUser")
    public String prepareEditUserForm(@PathVariable Long id, Model model) {
        model.addAttribute( "userToEdit", userService.findUserByIdAndFill( id ) );
        User user = userRepository.findById( id ).orElse( null );
        if (user == null) {
            return "redirect:/userList";
        }
        model.addAttribute( "toEdit", user );
        return "/editUser";
    }
    @PostMapping("/editUser")
    public String saveEditUserChanges(@ModelAttribute("userToEdit") @Valid UserFormDto form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/admin/userList";
        }
        boolean success = userService.updateUserByAdmin( form );
        if (success) {
            return "redirect:/admin/userList";
        } else {
            result.rejectValue( "email", null, "Cos poszło źle, spróbuj jeszcze raz" );
            return "/" + form.getId() + "/editUser";
        }
    }


}
