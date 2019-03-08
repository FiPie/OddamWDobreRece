package com.f.piechowiak.spring.OddamWDobreRece.web.controllers;

import com.f.piechowiak.spring.OddamWDobreRece.core.DonationService;
import com.f.piechowiak.spring.OddamWDobreRece.dto.DonationDto;
import com.f.piechowiak.spring.OddamWDobreRece.models.*;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    DonationService donationService;


    @Autowired
    public DonationFormController() {
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
    public String donationsDashboard(Model model, Principal principal) {


        return "donationDashboard";
    }

    /*STEP 1*/
    @GetMapping("/formStep1")
    public String prepareDonationForm1(Model model, Principal principal) {
        List<GiftType> allGiftTypes = giftTypeReposiotry.findAll();
        model.addAttribute( "giftTypeList", allGiftTypes );
        model.addAttribute( "donationForm", new DonationDto() );
        return "formStep1";
    }

    @PostMapping("/formStep1")
    public String formStep1(@ModelAttribute("donationForm") @Valid DonationDto form, Model model) {
        /*DonationDto donationDtoToForward = donationService.fillPartiallyDonationDto( form );
        model.addAttribute( "donationForm", donationDtoToForward );*/

        List<GiftType> giftTypesSelected = form.getGiftTypeList();
        session.setAttribute( "giftTypesSelected", giftTypesSelected );
        session.setAttribute( "form1", form );
        System.err.println( "Size of GiftTypeList is : " + giftTypesSelected.size() );
        System.err.println( "Content of GiftTypeList is : " + Arrays.toString( giftTypesSelected.toArray() ) );

        return ("redirect:/user/donations/formStep2");
    }


    /*STEP 2*/
    @GetMapping("/formStep2")
    public String prepareDonationForm2(Model model) {
        /*DonationDto donationDtoToForward = (DonationDto) session.getAttribute( "donationForm" );
        model.addAttribute( "donationForm", donationDtoToForward );*/

        model.addAttribute( "donationForm", new DonationDto() );
        System.err.println( "GiftTypeList from session : " + session.getAttribute( "giftTypesSelected" ).getClass().getTypeName() );
        return "formStep2";
    }

    @PostMapping("/formStep2")
    public String formStep2(@ModelAttribute("donationForm") @Valid DonationDto form) {
        //DonationDto donationDtoToForward = donationService.fillPartiallyDonationDto( form );
        session.setAttribute( "form2", form );

        Long quantitySelected = form.getQuantity();
        session.setAttribute( "quantitySelected", quantitySelected );
        System.err.println( "Quantity of bags : " + quantitySelected );

        return "redirect:/user/donations/formStep3";
    }


    /*STEP 3*/
    @GetMapping("/formStep3")
    public String prepareDonationForm3(Model model) {

        model.addAttribute( "donationForm", new DonationDto() );

        List<String> cityList = charityRepository.getCityList();
        model.addAttribute( "cityList", cityList );
        List<CharityActivity> charityActivityList = charityActivityRepository.findAll();
        model.addAttribute( "charityActivityList", charityActivityList );
        List<Charity> charityList = charityRepository.findAll();
        model.addAttribute( "charityList", charityList );

        return "formStep3";
    }

    @PostMapping("/formStep3")
    public String formStep3(@ModelAttribute("donationForm") @Valid DonationDto form, Model model) {


        session.setAttribute( "form3", form );

        return "redirect:/user/donations/formStep4";
    }


    /*STEP 4*/
    @GetMapping("/formStep4")
    public String prepareDonationForm4(Model model) {

        DonationDto form3 = (DonationDto) session.getAttribute( "form3" );
        DonationDto form1 = (DonationDto) session.getAttribute( "form1" );

        String city = form3.getSelectedCharityCity();
        System.err.println( "city: " + city );

        String selectedCharityName;
        if (session.getAttribute( "form3" ) != null) {
            selectedCharityName = form3.getSelectedCharityName();
            System.err.println( "Selected charityName: " + selectedCharityName );
        }

        List<Long> activityIdList = new ArrayList<>();
        if (session.getAttribute( "form3" ) != null) {
            List<CharityActivity> selectedCharityActivityList = form3.getSelectedCharityActivityList();
            System.err.println( "charityActivityList size: " + selectedCharityActivityList.size() );
            for (CharityActivity ca : selectedCharityActivityList) {
                activityIdList.add( ca.getId() );
            }
        }

        List<GiftType> acceptedGiftList = form1.getGiftTypeList();
        List<Charity> selectedCharities = charityRepository.findDistinctByCharityActivityType_IdInAndAcceptedGiftTypesInAndCityIs( activityIdList, acceptedGiftList, city );

        List<Long> acceptedGiftIds = acceptedGiftList.stream().map( GiftType::getId ).collect( Collectors.toList() );

        List<Charity> charityListContainingAllCategories = selectedCharities.stream().filter( charity -> {
            List<Long> acceptedGiftTypesByCharity = charity.getAcceptedGiftTypes().stream().map( GiftType::getId ).collect( Collectors.toList() );
            return acceptedGiftTypesByCharity.containsAll( acceptedGiftIds );
        } ).collect( Collectors.toList() );


        model.addAttribute( "selectedCharities", charityListContainingAllCategories );
        model.addAttribute( "donationForm", new DonationDto() );

        return "formStep4";
    }

    @PostMapping("/formStep4")
    public String formStep4(@ModelAttribute("donationForm") @Valid DonationDto form) {

        session.setAttribute( "form4", form );

        Charity selectedCharity = form.getCharity();
        session.setAttribute( "selectedCharity", selectedCharity );
        System.err.println("Selected Charity : "+selectedCharity.toString());

        return "redirect:/user/donations/formStep5";
    }

    /*STEP 5*/
    @GetMapping("/formStep5")
    public String prepareDonationForm5(Model model, Principal principal) {
        model.addAttribute( "donationForm", new DonationDto() );
        return "formStep5";
    }

    @PostMapping("/formStep5")
    public String formStep5(@ModelAttribute("donationForm") @Valid DonationDto form, Model model) {
        DonationDto donationDtoToForward = donationService.fillPartiallyDonationDto( form );
        session.setAttribute( "form5", donationDtoToForward );
        return "redirect:/user/donations/formStep6";
    }


    /*STEP 6*/
    @GetMapping("/formStep6")
    public String prepareDonationForm6(Model model, Principal principal) {
        DonationDto finalDto = (DonationDto) session.getAttribute( "donationForm" );
        model.addAttribute( "finalDto", finalDto );


        return "formStep6";
    }

    /*STEP 7*/
    @GetMapping("/formStep7")
    public String prepareDonationForm7(Model model, Principal principal) {

        return "formStep7";
    }

}
