package com.f.piechowiak.spring.OddamWDobreRece.web.controllers;

import com.f.piechowiak.spring.OddamWDobreRece.models.User;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@RequestMapping("/")
public class HomepageController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    HttpSession session;


    @GetMapping
    public String getHomepage(Principal principal, Model model){



        if (principal != null){
            if (session.getAttribute( "userId" )==null){
                String userEmail = principal.getName();
                Long userId = userRepository.findByEmail( userEmail ).getId();
                System.err.println( "Wstawilem do sesji userId: "+ userId );
                boolean enabled = userRepository.findByEmail( userEmail ).isEnabled();
                if (enabled == false){
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


}
