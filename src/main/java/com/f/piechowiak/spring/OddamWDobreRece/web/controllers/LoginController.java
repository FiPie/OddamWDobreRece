package com.f.piechowiak.spring.OddamWDobreRece.web.controllers;

import com.f.piechowiak.spring.OddamWDobreRece.dto.LoginFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.dto.UserFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    HttpSession session;

    @GetMapping
    public String prepareLoginForm(Model model){
        model.addAttribute( "loginFormDto", new LoginFormDto() );
        return "login";
    }


}
