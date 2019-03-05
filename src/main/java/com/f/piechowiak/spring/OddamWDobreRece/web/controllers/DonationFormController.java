package com.f.piechowiak.spring.OddamWDobreRece.web.controllers;

import com.f.piechowiak.spring.OddamWDobreRece.dto.DonationDto;
import com.f.piechowiak.spring.OddamWDobreRece.models.*;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

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
        User user = userRepository.findByEmail( principal.getName() );
        model.addAttribute( "loggedUser", user );

        List<GiftType> allGiftTypes = giftTypeReposiotry.findAll();
        model.addAttribute( "giftTypeList", allGiftTypes );
        List<CharityType> charityTypeList = charityTypeRepository.findAll();
        model.addAttribute( "charityTypeList", charityTypeList );
        List<CharityActivity> charityActivityList = charityActivityRepository.findAll();
        model.addAttribute( "charityActivityList", charityActivityList );
        List<Charity>charityList = charityRepository.findAll();
        model.addAttribute( "charityList",charityList );
        List<String>cityList = charityRepository.getCityList();
        model.addAttribute( "cityList",cityList );


        model.addAttribute( "donationForm", new DonationDto() );
        return "formStep1";
    }


    @GetMapping("/formStep2")
    public String prepareDonationForm2(Model model, Principal principal){
        User user = userRepository.findByEmail( principal.getName() );
        model.addAttribute( "loggedUser", user );

        List<GiftType> allGiftTypes = giftTypeReposiotry.findAll();
        model.addAttribute( "giftTypeList", allGiftTypes );
        List<CharityType> charityTypeList = charityTypeRepository.findAll();
        model.addAttribute( "charityTypeList", charityTypeList );
        List<CharityActivity> charityActivityList = charityActivityRepository.findAll();
        model.addAttribute( "charityActivityList", charityActivityList );
        List<Charity>charityList = charityRepository.findAll();
        model.addAttribute( "charityList",charityList );
        List<String>cityList = charityRepository.getCityList();
        model.addAttribute( "cityList",cityList );


        model.addAttribute( "donationForm", new DonationDto() );
        return "formStep2";
    }



    @GetMapping("/formStep3")
    public String prepareDonationForm3(Model model, Principal principal){
        User user = userRepository.findByEmail( principal.getName() );
        model.addAttribute( "loggedUser", user );

        List<GiftType> allGiftTypes = giftTypeReposiotry.findAll();
        model.addAttribute( "giftTypeList", allGiftTypes );
        List<CharityType> charityTypeList = charityTypeRepository.findAll();
        model.addAttribute( "charityTypeList", charityTypeList );
        List<CharityActivity> charityActivityList = charityActivityRepository.findAll();
        model.addAttribute( "charityActivityList", charityActivityList );
        List<Charity>charityList = charityRepository.findAll();
        model.addAttribute( "charityList",charityList );
        List<String>cityList = charityRepository.getCityList();
        model.addAttribute( "cityList",cityList );

        model.addAttribute( "donationForm", new DonationDto() );
        return "formStep3";
    }

    @GetMapping("/formStep4")
    public String prepareDonationForm4(Model model, Principal principal){
        User user = userRepository.findByEmail( principal.getName() );
        model.addAttribute( "loggedUser", user );

        List<GiftType> allGiftTypes = giftTypeReposiotry.findAll();
        model.addAttribute( "giftTypeList", allGiftTypes );
        List<CharityType> charityTypeList = charityTypeRepository.findAll();
        model.addAttribute( "charityTypeList", charityTypeList );
        List<CharityActivity> charityActivityList = charityActivityRepository.findAll();
        model.addAttribute( "charityActivityList", charityActivityList );
        List<Charity>charityList = charityRepository.findAll();
        model.addAttribute( "charityList",charityList );
        List<String>cityList = charityRepository.getCityList();
        model.addAttribute( "cityList",cityList );

        model.addAttribute( "donationForm", new DonationDto() );
        return "formStep4";
    }

    @GetMapping("/formStep5")
    public String prepareDonationForm5(Model model, Principal principal){
        User user = userRepository.findByEmail( principal.getName() );
        model.addAttribute( "loggedUser", user );

        List<GiftType> allGiftTypes = giftTypeReposiotry.findAll();
        model.addAttribute( "giftTypeList", allGiftTypes );
        List<CharityType> charityTypeList = charityTypeRepository.findAll();
        model.addAttribute( "charityTypeList", charityTypeList );
        List<CharityActivity> charityActivityList = charityActivityRepository.findAll();
        model.addAttribute( "charityActivityList", charityActivityList );
        List<Charity>charityList = charityRepository.findAll();
        model.addAttribute( "charityList",charityList );
        List<String>cityList = charityRepository.getCityList();
        model.addAttribute( "cityList",cityList );

        model.addAttribute( "donationForm", new DonationDto() );
        return "formStep5";
    }

    @GetMapping("/formStep6")
    public String prepareDonationForm6(Model model, Principal principal){
        User user = userRepository.findByEmail( principal.getName() );
        model.addAttribute( "loggedUser", user );

        List<GiftType> allGiftTypes = giftTypeReposiotry.findAll();
        model.addAttribute( "giftTypeList", allGiftTypes );
        List<CharityType> charityTypeList = charityTypeRepository.findAll();
        model.addAttribute( "charityTypeList", charityTypeList );
        List<CharityActivity> charityActivityList = charityActivityRepository.findAll();
        model.addAttribute( "charityActivityList", charityActivityList );
        List<Charity>charityList = charityRepository.findAll();
        model.addAttribute( "charityList",charityList );
        List<String>cityList = charityRepository.getCityList();
        model.addAttribute( "cityList",cityList );

        model.addAttribute( "donationForm", new DonationDto() );
        return "formStep6";
    }

    @GetMapping("/formStep7")
    public String prepareDonationForm7(Model model, Principal principal){
        User user = userRepository.findByEmail( principal.getName() );
        model.addAttribute( "loggedUser", user );

        List<GiftType> allGiftTypes = giftTypeReposiotry.findAll();
        model.addAttribute( "giftTypeList", allGiftTypes );
        List<CharityType> charityTypeList = charityTypeRepository.findAll();
        model.addAttribute( "charityTypeList", charityTypeList );
        List<CharityActivity> charityActivityList = charityActivityRepository.findAll();
        model.addAttribute( "charityActivityList", charityActivityList );
        List<Charity>charityList = charityRepository.findAll();
        model.addAttribute( "charityList",charityList );
        List<String>cityList = charityRepository.getCityList();
        model.addAttribute( "cityList",cityList );

        model.addAttribute( "donationForm", new DonationDto() );
        return "formStep7";
    }

}
