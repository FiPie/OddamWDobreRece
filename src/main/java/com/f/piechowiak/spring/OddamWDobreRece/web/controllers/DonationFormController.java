package com.f.piechowiak.spring.OddamWDobreRece.web.controllers;

import com.f.piechowiak.spring.OddamWDobreRece.dto.DonationDto;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@RequestMapping("/user/donations")             //to be checked if correct
public class DonationFormController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    HttpSession session;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    DonationRepository donationRepository;
    @Autowired
    CharityRepository charityRepository;
    @Autowired
    CharityTypeRepository charityTypeRepository;
    @Autowired
    CharityActivityRepository charityActivityRepository;
    @Autowired
    GiftTypeReposiotry giftTypeReposiotry;

    @Autowired
    public DonationFormController(){
        this.userRepository = userRepository;
        this.session = session;
        this.userRoleRepository = userRoleRepository;
        this.donationRepository = donationRepository;
        this.charityRepository = charityRepository;
        this.charityTypeRepository = charityTypeRepository;
        this.charityActivityRepository = charityActivityRepository;
        this.giftTypeReposiotry = giftTypeReposiotry;
    }


    @GetMapping("/")
    public String donationsDashboard(Model model, Principal principal){


        return "donationDashboard";
    }


    @GetMapping("/formStep1")
    public String prepareDonationForm1(Model model, Principal principal){
        model.addAttribute( "DonationForm", new DonationDto() );
        return "formStep1";
    }



}
