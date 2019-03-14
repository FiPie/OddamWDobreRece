package com.f.piechowiak.spring.OddamWDobreRece.web.controllers;

import com.f.piechowiak.spring.OddamWDobreRece.core.CharityService;
import com.f.piechowiak.spring.OddamWDobreRece.core.DonationService;
import com.f.piechowiak.spring.OddamWDobreRece.core.GiftTypeService;
import com.f.piechowiak.spring.OddamWDobreRece.core.UserService;
import com.f.piechowiak.spring.OddamWDobreRece.dto.DonationDto;
import com.f.piechowiak.spring.OddamWDobreRece.dto.RegistrationFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.email.EmailSender;
import com.f.piechowiak.spring.OddamWDobreRece.models.*;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.*;
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
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user/donations")             //to be checked if correct
public class DonationFormController {

    final
    UserRepository userRepository;
    final
    HttpSession session;
    final
    UserRoleRepository userRoleRepository;
    final
    DonationRepository donationRepository;
    final
    CharityRepository charityRepository;
    final
    CharityTypeRepository charityTypeRepository;
    final
    CharityActivityRepository charityActivityRepository;
    final
    GiftTypeReposiotry giftTypeReposiotry;
    final
    DonationService donationService;
    final
    GiftTypeService giftTypeService;
    final
    UserService userService;
    final
    CharityService charityService;
    final
    EmailSender emailSender;

    @Autowired
    public DonationFormController(UserRepository userRepository, HttpSession session, UserRoleRepository userRoleRepository, DonationRepository donationRepository, CharityRepository charityRepository, CharityTypeRepository charityTypeRepository, CharityActivityRepository charityActivityRepository, GiftTypeReposiotry giftTypeReposiotry, DonationService donationService, GiftTypeService giftTypeService, UserService userService, CharityService charityService, EmailSender emailSender) {
        this.userRepository = userRepository;
        this.session = session;
        this.userRoleRepository = userRoleRepository;
        this.donationRepository = donationRepository;
        this.charityRepository = charityRepository;
        this.charityTypeRepository = charityTypeRepository;
        this.charityActivityRepository = charityActivityRepository;
        this.giftTypeReposiotry = giftTypeReposiotry;
        this.donationService = donationService;
        this.giftTypeService = giftTypeService;
        this.userService = userService;
        this.charityService = charityService;
        this.emailSender = emailSender;
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

        User donatingUser = userRepository.findByEmail( principal.getName() );
        model.addAttribute( "donatingUser", donatingUser );
        System.err.println( "User donator : " + donatingUser );

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
        System.err.println( "Selected Charity : " + selectedCharity.toString() );

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
        DonationDto form5 = (DonationDto) session.getAttribute( "form5" );
        DonationDto form4 = (DonationDto) session.getAttribute( "form4" );
        DonationDto form2 = (DonationDto) session.getAttribute( "form2" );
        DonationDto form1 = (DonationDto) session.getAttribute( "form1" );

        Charity charity = form4.getCharity();
        List<Long> longList=new ArrayList<>(  );
        List<GiftType> giftTypeList = form1.getGiftTypeList();
        for (GiftType giftType : giftTypeList
             ) {
                longList.add(giftType.getId());
        }


        User donatingUser = userRepository.findByEmail( principal.getName() );
        Long quantity = form2.getQuantity();

        model.addAttribute( "donationForm", new DonationDto() );
        model.addAttribute( "form5", form5 );
        model.addAttribute( "form1", form1 );
        model.addAttribute( "form4", form4 );
        model.addAttribute( "form2", form2 );


        model.addAttribute( "charity", charity );
        model.addAttribute( "giftTypeList", longList );
        model.addAttribute( "donatingUser", donatingUser );
        model.addAttribute( "quantity", quantity );


        System.err.println( "GiftTypeList from form1 :" + giftTypeList );
        System.err.println( "GiftTypeList from form1 :" + longList );

        return "formStep6";
    }

    @PostMapping("/formStep6")
    public String formStep6(@ModelAttribute("donationForm") @Valid DonationDto form, BindingResult result) {


        if (result.hasErrors()) {

            return "/formStep6";
        }
        boolean success = donationService.createDonation( form );
        if (success) {
            emailSender.sendEmail( form.getUser().getEmail(), "OddamWDobreRece - Informacje nt. odbioru dokonanej darowizny "+ form.getUser().getEmail(), prepareEmail( form ) );
            return "redirect:/user/donations/formStep7";
        } else {
            result.rejectValue( "charityName", null, "Cos poszlo nietak, sprobuj jeszcze raz:)" );
            return "/formStep6";

        }

    }


    /*STEP 7*/
    @GetMapping("/formStep7")
    public String prepareDonationForm7() {


        return "formStep7";
    }

    private String prepareEmail(@ModelAttribute("donationDto") @Valid DonationDto form){
        StringBuilder sb = new StringBuilder(  );
        sb.append( "Witaj <b>" )
                .append( form.getUser().getFirstName() ).append( " " )
                .append( form.getUser().getLastName() )
                .append( "</b>, <br><br>" )
                .append( "Poniżej znajdziesz szczegóły odbioru Twojej darowizny: " )
                .append( "Kurier OddamWDobreRece odbierze od Ciebie : " ).append( "<br>" )
                .append( form.getQuantity() ).append( " worków 60l " )
                .append( "W dniu : " ).append( form.getPickUpDate() )
                .append( ", o godzinie : " ).append( form.getPickUpHour() ).append( "<br>" )
                .append( "Pod adresem : " ).append( "<br>" )
                .append( "Ul." ).append( form.getStreet() ).append( "<br>" )
                .append( form.getCity() ).append( " , Kod Pocztowy: " ).append( form.getPostCode() ).append( "<br>" )
                .append( "Kurier ma Twój numer telefoniczny : " ).append( form.getPhone() ).append( "<br>" )
                .append( "Twoje ewentualne uwagi dla kuriera : " ).append( form.getNotes() ).append( "<br>" )
                .append( "Gdybyś miał/a jakiekolwiek problemy z użytkowaniem naszego portalu skontaktuj się z nami!" ).append( "<br>" )
                .append( "http://localhost:5000/contact" ).append( "<br>" )
                .append( "Pozdrawiamy :)" ).append( "<br>" )
                .append( "Zespół OddamWDobreRece.pl" );

        return sb.toString();

    }

}
