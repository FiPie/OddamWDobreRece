package com.f.piechowiak.spring.OddamWDobreRece.web.controllers;

import com.f.piechowiak.spring.OddamWDobreRece.core.RegistrationService;
import com.f.piechowiak.spring.OddamWDobreRece.dto.RegistrationFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.email.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final EmailSender emailSender;


    public RegistrationController(RegistrationService registrationService, EmailSender emailSender) {
        this.registrationService = registrationService;
        this.emailSender = emailSender;
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
        String emailAddress = form.getEmail();
        if (success) {
            emailSender.sendEmail( emailAddress, "OddamWDobreRece - Utworzono konto użytkownika "+ form.getEmail(), prepareWelcomeEmail( form ) );
            return "redirect:/login";
        } else {
            result.rejectValue( "email", null, "Cos poszlo nietak przy wpisywaniu danych w formularzu rejestracji, sprobuj jeszcze raz:)" );
            return "register";
        }
    }

    private String prepareWelcomeEmail(@ModelAttribute("registrationForm") @Valid RegistrationFormDto form){
        StringBuilder sb = new StringBuilder(  );
        sb.append( "Witaj <b>" )
                .append( form.getFirstName()).append( " " )
                .append( form.getLastName())
                .append( "</b>, <br><br>" )
                .append( "Utworzyliśmy dla Ciebie konto w aplikacji: " )
                .append( "OddamWDobreRece" ).append( "<br>" )
                .append( "Twój login to: " ).append( form.getEmail() ).append( "<br>" )
                .append( "Możesz skorzystać z poniższego linka i przejść bezpośrednio do strony logowania!" ).append( "<br>" )
                .append( "http://localhost:5000/login" ).append( "<br>" )
                .append( "Pozdrawiamy :)" ).append( "<br>" )
                .append( "Zespół OddamWDobreRece.pl" );

        return sb.toString();

    }



}
