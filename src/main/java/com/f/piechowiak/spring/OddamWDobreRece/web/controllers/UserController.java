package com.f.piechowiak.spring.OddamWDobreRece.web.controllers;

import com.f.piechowiak.spring.OddamWDobreRece.core.UserService;
import com.f.piechowiak.spring.OddamWDobreRece.models.User;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.UserRepository;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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

    public UserController (UserService userService){this.userService = userService;}

    @GetMapping("/dashboard")
    public String prepareAdminDashboard(Model model, Principal principal) {
        User user = userRepository.findByEmail( principal.getName() );
        model.addAttribute( "LoggedUser", user );

        return "userDashboard";
    }




}
