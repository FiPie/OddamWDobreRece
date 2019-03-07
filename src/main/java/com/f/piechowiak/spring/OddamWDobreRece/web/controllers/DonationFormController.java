package com.f.piechowiak.spring.OddamWDobreRece.web.controllers;

import com.f.piechowiak.spring.OddamWDobreRece.core.DonationService;
import com.f.piechowiak.spring.OddamWDobreRece.dto.CharityFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.dto.DonationDto;
import com.f.piechowiak.spring.OddamWDobreRece.dto.FormSearchDto;
import com.f.piechowiak.spring.OddamWDobreRece.models.*;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.*;
import com.sun.org.apache.bcel.internal.generic.LNEG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
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
        model.addAttribute( "donationForm", donationDtoToForward );
        session.setAttribute( "donationForm", donationDtoToForward );*/
        List<GiftType> giftTypesSelected = form.getGiftTypeList();
        session.setAttribute( "giftTypesSelected", giftTypesSelected );
        session.setAttribute( "form1", form );
        System.err.println( "Size of GiftTypeList is : " + giftTypesSelected.size() );
        System.err.println( "Content of GiftTypeList is : " + Arrays.toString( giftTypesSelected.toArray() ));

        return ("redirect:/user/donations/formStep2");
    }


    /*STEP 2*/
    @GetMapping("/formStep2")
    public String prepareDonationForm2(Model model) {
        /*DonationDto donationDtoToForward = (DonationDto) session.getAttribute( "donationForm" );
        model.addAttribute( "donationForm", donationDtoToForward );*/
        model.addAttribute( "donationForm", new DonationDto() );
        System.err.println( "GiftTypeList from session : " + session.getAttribute( "giftTypesSelected" ).getClass().isArray() );
        return "formStep2";
    }

    @PostMapping("/formStep2")
    public String formStep2(@ModelAttribute("donationForm") @Valid DonationDto form) {
        //DonationDto donationDtoToForward = donationService.fillPartiallyDonationDto( form );
        Long quantitySelected = form.getQuantity();
        session.setAttribute( "quantitySelected", quantitySelected );
        session.setAttribute( "form2", form );
        System.err.println( "Quantity of bags : " + quantitySelected );

        return "redirect:/user/donations/formStep3";
    }


    /*STEP 3*/
    @GetMapping("/formStep3")
    public String prepareDonationForm3(Model model) {

        model.addAttribute( "charityForm", new FormSearchDto() );

        List<String> cityList = charityRepository.getCityList();
        model.addAttribute( "cityList", cityList );
        List<CharityActivity> charityActivityList = charityActivityRepository.findAll();
        model.addAttribute( "charityActivityList", charityActivityList );
        List<Charity> charityList = charityRepository.findAll();
        model.addAttribute( "charityList", charityList );

        return "formStep3";
    }

    @PostMapping("/formStep3")
    public String formStep3(@ModelAttribute("charityForm") @Valid FormSearchDto form, Model model) {

        /*session.setAttribute( "selectedCharityActivities", form.getCharityActivityList() );
        session.setAttribute( "selectedCharityCity", form.getCity() );
        session.setAttribute( "selectedCharityName", form.getCharityName() );

        System.err.println( "charityActivityList size : " + form.getCharityActivityList().size() );*/
        session.setAttribute( "searchForm", form );

        return "redirect:/user/donations/formStep4";
    }


    /*STEP 4*/
    @GetMapping("/formStep4")
    public String prepareDonationForm4(Model model) {

        FormSearchDto search = (FormSearchDto) session.getAttribute( "searchForm" );
        DonationDto form1 = (DonationDto) session.getAttribute( "form1" );

        String city = search.getCity();
        System.err.println( "city: " + city );

        String charityName;
        if (session.getAttribute( "searchForm" ) != null) {
            charityName = search.getCharityName();
            System.err.println( "charityName: " + charityName );
        }

        List<Long> activityIdList = new ArrayList<>();
        if (session.getAttribute( "searchForm" ) != null) {
            List<CharityActivity> charityActivityList = search.getCharityActivityList();
            System.err.println( "charityActivityList size: " + charityActivityList.size() );
            for (CharityActivity ca : charityActivityList) {
                activityIdList.add( ca.getId() );
            }
        }

        List<GiftType> acceptedGiftList = form1.getGiftTypeList();

        //System.err.println( "activityIdList size: " + activityIdList.size() );
        List<Charity> selectedCharities = charityRepository.findDistinctByCharityActivityType_IdInAndAcceptedGiftTypesInAndCityIs( activityIdList, acceptedGiftList, city );

        List<Long> acceptedGiftIds = acceptedGiftList.stream().map( GiftType::getId ).collect( Collectors.toList() );

        List<Charity> charityListContainingAllCategories = selectedCharities.stream().filter( charity -> {
            List<Long> acceptedGiftTypesByCharity = charity.getAcceptedGiftTypes().stream().map( GiftType::getId ).collect( Collectors.toList() );
            return acceptedGiftTypesByCharity.containsAll( acceptedGiftIds );
        } ).collect( Collectors.toList());


        /*List<Long> podaneGiftTajpyId = podaneGiftTajpy.stream().map(type -> AcceptedType::getId).collect( Collectors.asList());

        List<Charity> charitiesContainingAtLeastOneCategory = repository.getTwojaMetoda();

        List<Charity> charityContainingAllCategories = charitiesContainingAtLeastOneCategory .stream().filter( new Predicament() {
            private boolean filter(Charity charity){
                List<Long> acceptedGiftTypesOfCharity =  charity.getAcceptedTypes.stream.map( type -> AcceptedType::getId).collect(Collectors.asList());
                return acceptedGiftTypesOfCharity.containsAll(podaneGiftTajpyId);
            }
        }).collect( Collector.asList());*/


        model.addAttribute( "selectedCharities", charityListContainingAllCategories );
        model.addAttribute( "donationForm", new DonationDto() );

        return "formStep4";
    }

    @PostMapping("/formStep4")
    public String formStep4(@ModelAttribute("donationForm") @Valid DonationDto form) {

        Charity selectedCharity = form.getCharity();
        session.setAttribute( "selectedCharity", selectedCharity );

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
        session.setAttribute( "donationForm", donationDtoToForward );
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
