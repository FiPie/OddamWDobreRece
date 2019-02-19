package com.f.piechowiak.spring.OddamWDobreRece.web.controllers;

import com.f.piechowiak.spring.OddamWDobreRece.dto.AdminFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.dto.LoginFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.models.User;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.AdminRepository;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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

    @GetMapping("/dashboard")
    public String prepareAdminForm(Principal principal, Model model){
        model.addAttribute( "AdminFormDto", new AdminFormDto() );

        return "adminDashboard";
    }

    @GetMapping("/userList")
    public String prepareUserListForm(Principal principal, Model model){
        model.addAttribute( "AdminFormDto", new AdminFormDto() );
        List<User> userList = userRepository.findAll();
        session.setAttribute( "userList", userList );

        return "userList";
    }

    @GetMapping("/adminList")
    public String prepareAdminListForm(Principal principal, Model model){
        model.addAttribute( "AdminFormDto", new AdminFormDto() );
        return "adminList";
    }

    @GetMapping("/orgList")
    public String prepareOrganizationListForm(Principal principal, Model model){
        model.addAttribute( "AdminFormDto", new AdminFormDto() );
        return "orgList";
    }

    @GetMapping("/giftList")
    public String prepareGiftListForm(Principal principal, Model model){
        model.addAttribute( "AdminFormDto", new AdminFormDto() );
        return "giftList";
    }


}
