package com.f.piechowiak.spring.OddamWDobreRece.web.controllers;


import com.f.piechowiak.spring.OddamWDobreRece.core.*;
import com.f.piechowiak.spring.OddamWDobreRece.dto.*;
import com.f.piechowiak.spring.OddamWDobreRece.models.*;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final
    UserRepository userRepository;
    private final
    HttpSession session;
    private final
    CharityRepository charityRepository;
    private final
    CharityTypeRepository charityTypeRepository;
    private final
    CharityActivityRepository charityActivityRepository;
    private final
    GiftTypeReposiotry giftTypeReposiotry;

    private final UserService userService;
    private final CharityService charityService;
    private final GiftTypeService giftTypeService;
    private final CharityActivityService charityActivityService;
    private final CharityTypeService charityTypeService;


    @Autowired
    public AdminController(
            UserRepository userRepository
            , HttpSession session
            , CharityRepository charityRepository
            , CharityTypeRepository charityTypeRepository
            , CharityActivityRepository charityActivityRepository
            , GiftTypeReposiotry giftTypeReposiotry
            , UserService userService
            , CharityService charityService
            , GiftTypeService giftTypeService
            , CharityActivityService charityActivityService, CharityTypeService charityTypeService) {
        this.userRepository = userRepository;
        this.session = session;
        this.charityRepository = charityRepository;
        this.charityTypeRepository = charityTypeRepository;
        this.charityActivityRepository = charityActivityRepository;
        this.giftTypeReposiotry = giftTypeReposiotry;
        this.userService = userService;
        this.charityService = charityService;
        this.giftTypeService = giftTypeService;
        this.charityActivityService = charityActivityService;
        this.charityTypeService = charityTypeService;
    }


    @GetMapping("/dashboard")
    public String prepareAdminDashboard(Model model, Principal principal) {
        String firstName = userRepository.findByEmail( principal.getName() ).getFirstName();
        session.setAttribute( "userFirstName", firstName );
        int numberOfUsers = userRepository.getUserList().size();
        int numberOfAdmins = userRepository.getAdminList().size();
        int numberOfOrganizations = charityRepository.findAll().size();
        int numberOfOrganizationActivities = charityActivityRepository.findAll().size();
        int numberOfOrganizationTypes = charityTypeRepository.findAll().size();
        model.addAttribute( "userNumber", numberOfUsers );
        model.addAttribute( "adminNumber", numberOfAdmins );
        model.addAttribute( "orgNumber", numberOfOrganizations );
        model.addAttribute( "orgActivityNumber", numberOfOrganizationActivities );
        model.addAttribute( "orgTypeNumber", numberOfOrganizationTypes );


        return "adminDashboard";
    }





    @GetMapping("/charityTypeList")
    public String prepareCharityTypeList(Model model) {
        List<CharityType> charityTypeList = charityTypeRepository.findAll();
        model.addAttribute( "charityTypeList", charityTypeList );
        return "charityTypeList";
    }

    @GetMapping("/charityTypeForm")
    public String prepareCharityTypeForm(Model model) {
        model.addAttribute( "charityTypeForm", new CharityTypeDto() );
        return "charityTypeForm";
    }

    @PostMapping("/charityTypeForm")
    public String createCharityType(@ModelAttribute("charityTypeForm") @Valid CharityTypeDto form, BindingResult result) {
        if (result.hasErrors()) {
            return "/charityTypeForm";
        }
        boolean success = charityTypeService.createCharityType( form );
        if (success) {
            return "redirect:/admin/charityTypeList";
        } else {
            result.rejectValue( "organizationType", null, "Cos poszło nietak przy wypełnianiu formularza" );
            return "/charityTypeForm";
        }

    }
    @GetMapping("/{id:[1-9]*[0-9]+}/confirmDeleteCharityType")
    public String confirmDeleteCharityType(@PathVariable Long id, Model model) {
        CharityType charityTypeToDelete = charityTypeRepository.findById( id ).orElse( null );
        if (charityTypeToDelete == null) {
            return "redirect:/admin/charityTypeList";
        }
        model.addAttribute( "toRemove", charityTypeToDelete );
        return "charityTypeDelete";
    }

    @GetMapping("{id:[1-9]*[0-9]+}/deleteCharityType")
    public String deleteCharityType(@PathVariable Long id) {
        CharityType charityTypeToDelete = charityTypeRepository.findById( id ).orElse( null );
        if (charityTypeToDelete != null) {
            charityTypeService.deleteCharityType( charityTypeToDelete.getId() );
        }
        return "redirect:/admin/charityTypeList";
    }
    @GetMapping("/{id:[1-9]*[0-9]+}/editCharityType")
    public String editCharityType(@PathVariable Long id, Model model) {
        model.addAttribute( "charityTypeToEdit", charityTypeService.findCharityTypeByIdAndFill( id ) );
        CharityType charityTypeToEdit = charityTypeRepository.findById( id ).orElse( null );

        if (charityTypeToEdit == null) {
            return "redirect:/charityTypeList";
        }
        model.addAttribute( "toEdit", charityTypeToEdit );
        return "charityTypeEdit";
    }

    @PostMapping("/editCharityType")
    public String saveEditCharityTypeChanges(@ModelAttribute("charityTypeToEdit") @Valid CharityTypeDto form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/admin/charityTypeList";
        }
        boolean success = charityTypeService.updateCharityType( form );
        if (success) {
            return "redirect:/admin/charityTypeList";
        } else {
            result.rejectValue( "organizationType", null, "Cos poszło źle, spróbuj jeszcze raz" );
            return "/" + form.getId() + "charityTypeEdit";
        }
    }






    @GetMapping("/charityActivityList")
    public String prepareCharityActivityList(Model model) {
        List<CharityActivity> charityActivityList = charityActivityRepository.findAll();
        model.addAttribute( "charityActivityList", charityActivityList );
        return "charityActivityList";
    }

    @GetMapping("/charityActivityForm")
    public String prepareCharityActivityForm(Model model) {
        model.addAttribute( "charityActivityForm", new CharityActivityDto() );
        return "charityActivityForm";
    }

    @PostMapping("/charityActivityForm")
    public String createCharityActivity(@ModelAttribute("charityActivityForm") @Valid CharityActivityDto form, BindingResult result) {
        if (result.hasErrors()) {
            return "/charityActivityForm";
        }
        boolean success = charityActivityService.createCharityActivity( form );
        if (success) {
            return "redirect:/admin/charityActivityList";
        } else {
            result.rejectValue( "organizationActivity", null, "Cos poszło nietak przy wypełnianiu formularza" );
            return "/charityActivityForm";
        }

    }
    @GetMapping("/{id:[1-9]*[0-9]+}/confirmDeleteCharityActivity")
    public String confirmDeleteCharityActivity(@PathVariable Long id, Model model) {
        CharityActivity charityActivityToDelete = charityActivityRepository.findById( id ).orElse( null );
        if (charityActivityToDelete == null) {
            return "redirect:/admin/charityActivityList";
        }
        model.addAttribute( "toRemove", charityActivityToDelete );
        return "charityActivityDelete";
    }

    @GetMapping("{id:[1-9]*[0-9]+}/deleteCharityActivity")
    public String deleteCharityActivity(@PathVariable Long id) {
        CharityActivity charityActivityToDelete = charityActivityRepository.findById( id ).orElse( null );
        if (charityActivityToDelete != null) {
            charityActivityService.deleteCharityActivity( charityActivityToDelete.getId() );
        }
        return "redirect:/admin/charityActivityList";
    }
    @GetMapping("/{id:[1-9]*[0-9]+}/editCharityActivity")
    public String editCharityActivity(@PathVariable Long id, Model model) {
        model.addAttribute( "charityActivityToEdit", charityActivityService.findCharityActivityByIdAndFill( id ) );
        CharityActivity charityActivityToEdit = charityActivityRepository.findById( id ).orElse( null );

        if (charityActivityToEdit == null) {
            return "redirect:/charityActivityList";
        }
        model.addAttribute( "toEdit", charityActivityToEdit );
        return "charityActivityEdit";
    }

    @PostMapping("/editCharityActivity")
    public String saveEditCharityActivityChanges(@ModelAttribute("charityActivityToEdit") @Valid CharityActivityDto form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/admin/charityActivityList";
        }
        boolean success = charityActivityService.updateCharityActivity( form );
        if (success) {
            return "redirect:/admin/charityActivityList";
        } else {
            result.rejectValue( "organizationActivity", null, "Cos poszło źle, spróbuj jeszcze raz" );
            return "/" + form.getId() + "charityActivityEdit";
        }
    }








    @GetMapping("/giftTypeList")
    public String prepareGiftTypeList(Model model) {
        List<GiftType> giftTypeList = giftTypeReposiotry.findAll();
        model.addAttribute( "giftTypeList", giftTypeList );
        return "giftTypeList";
    }

    @GetMapping("/giftTypeForm")
    public String prepareGiftTypeForm(Model model) {
        model.addAttribute( "giftTypeForm", new GiftFormDto() );
        return "giftTypeForm";
    }

    @PostMapping("/giftTypeForm")
    public String createGiftType(@ModelAttribute("giftTypeForm") @Valid GiftFormDto form, BindingResult result) {
        if (result.hasErrors()) {
            return "/giftTypeForm";
        }
        boolean success = giftTypeService.createGiftType( form );
        if (success) {
            return "redirect:/admin/giftList";
        } else {
            result.rejectValue( "giftType", null, "Cos poszło nietak przy wypełnianiu formularza" );
            return "/giftTypeForm";
        }
    }

    @GetMapping("/{id:[1-9]*[0-9]+}/confirmDeleteGiftType")
    public String confirmDeleteGiftType(@PathVariable Long id, Model model) {
        GiftType giftTypeToDelete = giftTypeReposiotry.findById( id ).orElse( null );
        if (giftTypeToDelete == null) {
            return "redirect:/admin/giftList";
        }
        model.addAttribute( "toRemove", giftTypeToDelete );
        return "giftTypeDelete";
    }

    @GetMapping("{id:[1-9]*[0-9]+}/deleteGiftType")
    public String deleteGiftType(@PathVariable Long id) {
        GiftType giftTypeToDelete = giftTypeReposiotry.findById( id ).orElse( null );
        if (giftTypeToDelete != null) {
            giftTypeService.deleteGiftType( giftTypeToDelete.getId() );
        }
        return "redirect:/admin/giftList";
    }

    @GetMapping("/{id:[1-9]*[0-9]+}/editGiftType")
    public String editGiftTypeForm(@PathVariable Long id, Model model) {
        model.addAttribute( "giftTypeToEdit", giftTypeService.findGiftTypeByIdAndFill( id ) );
        GiftType giftTypeToEdit = giftTypeReposiotry.findById( id ).orElse( null );

        if (giftTypeToEdit == null) {
            return "redirect:/giftList";
        }
        model.addAttribute( "toEdit", giftTypeToEdit );
        return "giftTypeEdit";
    }

    @PostMapping("/editGiftType")
    public String saveEditGiftTypeChanges(@ModelAttribute("giftTypeToEdit") @Valid GiftFormDto form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/admin/giftList";
        }
        boolean success = giftTypeService.updateGiftType( form );
        if (success) {
            return "redirect:/admin/giftList";
        } else {
            result.rejectValue( "giftType", null, "Cos poszło źle, spróbuj jeszcze raz" );
            return "/" + form.getId() + "giftTypeEdit";
        }
    }


    @GetMapping("/orgList")
    public String prepareOrganizationListView(Model model) {
        List<Charity> organizationList = charityRepository.findAll();
        model.addAttribute( "organizationList", organizationList );
        return "charityList";
    }

    @GetMapping("/organizationForm")
    public String prepareOrganizationForm(Model model) {
        model.addAttribute( "orgForm", new OrgFormDto() );
        List<GiftType> allGiftTypes = giftTypeReposiotry.findAll();
        model.addAttribute( "giftTypeList", allGiftTypes );
        List<CharityType> charityTypeList = charityTypeRepository.findAll();
        model.addAttribute( "charityTypeList", charityTypeList );
        List<CharityActivity> charityActivityList = charityActivityRepository.findAll();
        model.addAttribute( "charityActivityList", charityActivityList );
        return "charityForm";
    }

    @PostMapping("/organizationForm")
    public String createOrganization(@ModelAttribute("orgForm") @Valid OrgFormDto form, BindingResult result) {
        if (result.hasErrors()) {
            return "/organizationForm";
        }
        boolean success = charityService.createOrganization( form );
        if (success) {
            return "redirect:/admin/orgList";
        } else {
            result.rejectValue( "charityName", null, "Cos poszlo nietak przy wpisywaniu danych w formularzu dodawania organizacji, sprobuj jeszcze raz:)" );
            return "/organizationForm";
        }
    }

    @GetMapping("/{id:[1-9]*[0-9]+}/confirmDeleteOrganization")
    public String confirmDeleteOrganization(@PathVariable Long id, Model model) {
        Charity org = charityRepository.findById( id ).orElse( null );
        if (org == null) {
            return "redirect:/admin/orgList";
        }
        model.addAttribute( "toRemove", org );
        return "charityDelete";
    }

    @GetMapping("/{id:[1-9]*[0-9]+}/deleteOrg")
    public String deleteOrganization(@PathVariable Long id) {
        Charity org = charityRepository.findById( id ).orElse( null );
        System.err.println( "Charity do usunieńcia: " + org.getCharityName() );
        if (org != null) {
            charityService.delete( org.getId() );
        }
        return "redirect:/admin/orgList";
    }

    @GetMapping("/{id:[1-9]*[0-9]+}/editOrganization")
    public String editOrganizationForm(@PathVariable Long id, Model model) {
        model.addAttribute( "orgToEdit", charityService.findCharityByIdAndFill( id ) );
        Charity org = charityRepository.findById( id ).orElse( null );
        List<GiftType> allGiftTypes = giftTypeReposiotry.findAll();
        List<CharityType> charityTypeList = charityTypeRepository.findAll();
        List<CharityActivity> charityActivityList = charityActivityRepository.findAll();
        model.addAttribute( "charityTypeList", charityTypeList );
        model.addAttribute( "giftTypeList", allGiftTypes );
        model.addAttribute( "charityActivityList", charityActivityList );
        if (org == null) {
            return "redirect:/orgList";
        }
        model.addAttribute( "toEdit", org );
        return "charityEdit";
    }

    @PostMapping("/editOrganization")
    public String saveEditOrganizationChanges(@ModelAttribute("orgToEdit") @Valid OrgFormDto form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/admin/orgList";
        }
        boolean success = charityService.updateCharityByAdmin( form );
        if (success) {
            return "redirect:/admin/orgList";
        } else {
            result.rejectValue( "charityName", null, "Cos poszło źle, spróbuj jeszcze raz" );
            return "/" + form.getId() + "/editOrganization";
        }
    }


    @GetMapping("/adminList")
    public String prepareAdminListForm() {
        List<User> adminList = userRepository.getAdminList();
        session.setAttribute( "adminList", adminList );
        return "adminList";
    }

    @GetMapping("/adminForm")
    public String prepareAdminForm(Model model) {
        model.addAttribute( "adminForm", new AdminFormDto() );
        return "adminForm";
    }

    @PostMapping("/adminForm")
    public String createNewAdmin(@ModelAttribute("adminForm") @Valid AdminFormDto form, BindingResult result) {
        if (result.hasErrors()) {
            return "/adminForm";
        }
        boolean success = userService.createAdmin( form );
        if (success) {
            return "redirect:/admin/adminList";
        } else {
            result.rejectValue( "email", null, "Cos poszlo nietak przy wpisywaniu danych w formularzu tworzenia admina, sprobuj jeszcze raz:)" );
            return "/adminForm";
        }
    }

    @GetMapping("/{id:[1-9]*[0-9]+}/confirmDeleteAdmin")
    public String confirmDeleteAdmin(@PathVariable Long id, Model model) {
        User user = userRepository.findById( id ).orElse( null );
        if (user == null) {
            return "redirect:/admin/adminList";
        }
        model.addAttribute( "toRemove", user );
        return "adminDelete";
    }

    @GetMapping("/{id:[1-9]*[0-9]+}/deleteAdmin")
    public String deleteAdmin(@PathVariable Long id, Principal principal) {
        int adminListSize = userRepository.getAdminList().size();
        User user = userRepository.findById( id ).orElse( null );

        if (adminListSize < 2) {
            System.err.println( "Nie możesz usunąć " + user.getFirstName() + " ponieważ wygląda na to, że jest to ostatni Admin w serwisie!" );
            return "redirect:/admin/adminList";
        }

        User loggedUser = userRepository.findByEmail( principal.getName() );
        System.err.println( "Admin do usunieńcia: " + user.getFirstName() );

        if (user != null) {
            if (user.equals( loggedUser )) {
                System.err.println( "Nie możesz usunąć sam siebie " + user.getFirstName() + "!" );
                return "redirect:/admin/adminList";
            } else {
                userService.delete( user.getId() );
            }
        }
        return "redirect:/admin/adminList";
    }

    @GetMapping("/{id:[1-9]*[0-9]+}/editAdmin")
    public String prepareEditAdminForm(@PathVariable Long id, Model model) {
        model.addAttribute( "adminToEdit", userService.findAdminByIdAndFill( id ) );
        User user = userRepository.findById( id ).orElse( null );
        if (user == null) {
            return "redirect:/adminList";
        }
        model.addAttribute( "toEdit", user );

        return "adminEdit";
    }

    @PostMapping("/editAdmin")
    public String saveEditAdminChanges(@ModelAttribute("adminToEdit") @Valid AdminFormDto form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/admin/adminList";
        }
        boolean success = userService.updateAdmin( form );
        if (success) {
            return "redirect:/admin/adminList";
        } else {
            result.rejectValue( "email", null, "Cos poszło źle, spróbuj jeszcze raz" );
            return "/" + form.getId() + "adminEdit";
        }
    }


    @GetMapping("/userList")
    public String prepareUserListForm() {
        List<User> userList = userRepository.getUserList();
        session.setAttribute( "userList", userList );
        return "adminUserList";
    }

    @GetMapping("/{id:[1-9]*[0-9]+}/confirmDeleteUser")
    public String confirmDeleteUser(@PathVariable Long id, Model model) {
        User user = userRepository.findById( id ).orElse( null );
        if (user == null) {
            return "redirect:/admin/userList";
        }
        model.addAttribute( "toRemove", user );
        return "adminUserDelete";
    }

    @GetMapping("/{id:[1-9]*[0-9]+}/deleteUser")
    public String deleteUser(@PathVariable Long id, Principal principal) {
        User user = userRepository.findById( id ).orElse( null );
        System.err.println( "User do usunieńcia: " + user.getFirstName() );
        if (user != null) {
            userService.delete( user.getId() );
        }
        return "redirect:/admin/userList";
    }

    @GetMapping("/{id:[1-9]*[0-9]+}/editUser")
    public String prepareEditUserForm(@PathVariable Long id, Model model) {
        model.addAttribute( "userToEdit", userService.findUserByIdAndFill( id ) );
        User user = userRepository.findById( id ).orElse( null );
        if (user == null) {
            return "redirect:/userList";
        }
        model.addAttribute( "toEdit", user );
        return "adminUserEdit";
    }

    @PostMapping("/editUser")
    public String saveEditUserChanges(@ModelAttribute("userToEdit") @Valid UserFormDto form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/admin/userList";
        }
        boolean success = userService.updateUserByAdmin( form );
        if (success) {
            return "redirect:/admin/userList";
        } else {
            result.rejectValue( "email", null, "Cos poszło źle, spróbuj jeszcze raz" );
            return "/" + form.getId() + "adminUserEdit";
        }
    }


}
