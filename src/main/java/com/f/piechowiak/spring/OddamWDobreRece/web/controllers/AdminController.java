package com.f.piechowiak.spring.OddamWDobreRece.web.controllers;

import com.f.piechowiak.spring.OddamWDobreRece.core.AdminService;
import com.f.piechowiak.spring.OddamWDobreRece.core.RegistrationService;
import com.f.piechowiak.spring.OddamWDobreRece.core.UserService;
import com.f.piechowiak.spring.OddamWDobreRece.dto.AdminFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.dto.LoginFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.dto.RegistrationFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.models.User;
import com.f.piechowiak.spring.OddamWDobreRece.models.UserRole;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.AdminRepository;
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
    private UserService userService;


    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/dashboard")
    public String prepareAdminDashboard(Model model) {
        model.addAttribute( "AdminFormDto", new AdminFormDto() );
        return "adminDashboard";
    }


    @GetMapping("/userList")
    public String prepareUserListForm(Model model) {
        model.addAttribute( "AdminFormDto", new AdminFormDto() );
        List<User> userList = userRepository.getUserList();
        session.setAttribute( "userList", userList );
        return "userList";
    }


    @GetMapping("/adminList")
    public String prepareAdminListForm(Model model) {
        model.addAttribute( "AdminFormDto", new AdminFormDto() );
        List<User> adminList = userRepository.getAdminList();
        session.setAttribute( "adminList", adminList );
        return "adminList";
    }


    @GetMapping("/orgList")
    public String prepareOrganizationListForm(Model model) {
        model.addAttribute( "AdminFormDto", new AdminFormDto() );
        return "orgList";
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
    public String registerUser(@ModelAttribute("adminForm") @Valid AdminFormDto form, BindingResult result) {
        if (result.hasErrors()) {
            return "/adminForm"; }
        boolean success = userService.createAdmin( form );
        if (success) {
            return "redirect:/admin/adminList";
        } else {
            result.rejectValue( "email", null, "Cos poszlo nietak przy wpisywaniu danych w formularzu tworzenia admina, sprobuj jeszcze raz:)" );
            return "/adminForm";
        }
    }



    @GetMapping("/{id:[1-9]*[0-9]+}/confirmDeleteAdmin")
    public String confirmDelete(@PathVariable Long id, Model model) {
        User user = userRepository.findById( id ).orElse( null );
        if (user == null){
            return "redirect:/admin/adminList";
        }
        model.addAttribute( "toRemove", user );
        return "/deleteAdmin";
    }

    @GetMapping("/{id:[1-9]*[0-9]+}/deleteAdmin")
    public String delete(@PathVariable Long id) {
        User user = userRepository.findById( id ).orElse( null );
        System.err.println("User do usunieńcia: " + user.getFirstName());
        if (user != null) {
            userRepository.delete(user);

        }
        return "redirect:/admin/adminList";
    }


    @GetMapping("/{id:[1-9]*[0-9]+}/editAdmin")
    public String prepareEditAdminForm(@PathVariable Long id, Model model) {
        model.addAttribute( "adminToEdit", userService.findByIdAndFill( id ) );
        User user = userRepository.findById( id ).orElse( null );
        if (user == null){
            return "redirect:/adminList";
        }
        model.addAttribute( "toEdit", user );

        return "/editAdmin";
    }
    @PostMapping("/editAdmin")
    public String saveEditAdminChanges(@ModelAttribute("adminToEdit") @Valid AdminFormDto form, BindingResult result, Model model){
        if (result.hasErrors()){
            return "/admin/adminList";
        }
        boolean success = userService.updateAdmin( form );
        if (success){
            return "redirect:/admin/adminList";
        }else {
            result.rejectValue( "email", null, "Cos poszło źle, spróbuj jeszcze raz" );
            return "/"+form.getId()+"/editAdmin";
        }


    }



}
