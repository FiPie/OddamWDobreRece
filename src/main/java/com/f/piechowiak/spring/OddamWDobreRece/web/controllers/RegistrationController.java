package com.f.piechowiak.spring.OddamWDobreRece.web.controllers;

import com.f.piechowiak.spring.OddamWDobreRece.core.RegistrationService;
import com.f.piechowiak.spring.OddamWDobreRece.dto.RegistrationFormDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String prepareRegistrationForm(Model model) {
        model.addAttribute( "registrationForm", new RegistrationFormDto() );

        return "register";
    }

    @PostMapping
    public String registerUser(@ModelAttribute("registrationForm") @Valid RegistrationFormDto form, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        boolean success = registrationService.register( form );
        if (success) {
            return "redirect:/login";
        } else {
            result.rejectValue( "email", null, "Cos poszlo nietak przy wpisywaniu danych w formularzu rejestracji, sprobuj jeszcze raz:)" );
            return "register";
        }
    }


}
