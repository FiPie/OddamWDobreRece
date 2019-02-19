package com.f.piechowiak.spring.OddamWDobreRece.web.controllers;

import com.f.piechowiak.spring.OddamWDobreRece.dto.AdminFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.dto.LoginFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.models.User;
import com.f.piechowiak.spring.OddamWDobreRece.models.UserRole;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.AdminRepository;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.UserRepository;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    HttpSession session;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    UserRoleRepository userRoleRepository;

    @GetMapping("/dashboard")
    public String prepareAdminForm(Principal principal, Model model) {
        model.addAttribute( "AdminFormDto", new AdminFormDto() );

        return "adminDashboard";
    }

    @GetMapping("/userList")
    public String prepareUserListForm(Principal principal, Model model) {
        model.addAttribute( "AdminFormDto", new AdminFormDto() );

        /*List<UserRole> userRoleList = userRoleRepository.findAllByRoleContaining( "ROLE_USER" );
        List<User> userList = null;
        for (UserRole userRole : userRoleList) {
            Long userId = userRole.getUser().getId();
            System.err.println("Current userId: "+userId);

            User user = userRepository.findOneById( userId );
            userList.add( user );
            System.err.println("Current user: "+user.getEmail());
        }*/

        /*List<User> userList = userRepository.findAll();
        for (User user:userList) {
            Long userId = user.getId();
            List<UserRole> userRoles = userRoleRepository.findAllByUserId( userId );
            for (UserRole userRole:userRoles) {
                System.err.println("Current user role: "+userRole.getRole());
                    if (userRole.getRole() == "ROLE_ADMIN"){
                        System.err.println("OBECNY USER W PĘTLI DO USUNIENCIA Z LISTY userList: "+ user.toString());
                        userList.remove( this );

                    }
            }

        }*/
        List<User> userList = userRepository.findAll();
        List<UserRole> userRoleList = userRoleRepository.findAllByRoleContaining( "ROLE_ADMIN" );

        for (int i = 0; i < userList.size(); i++) {
            Long userId = userList.get( i ).getId();
            for (int j = 0; j < userRoleList.size(); j++) {
                if (userRoleList.get( j ).getUser().getId() == userId){
                    userList.remove( userList.get( i ) );
                }
            }
        }
        
        session.setAttribute( "userList", userList );

        return "userList";
    }

    @GetMapping("/adminList")
    public String prepareAdminListForm(Principal principal, Model model) {
        model.addAttribute( "AdminFormDto", new AdminFormDto() );
        return "adminList";
    }

    @GetMapping("/orgList")
    public String prepareOrganizationListForm(Principal principal, Model model) {
        model.addAttribute( "AdminFormDto", new AdminFormDto() );
        return "orgList";
    }

    @GetMapping("/giftList")
    public String prepareGiftListForm(Principal principal, Model model) {
        model.addAttribute( "AdminFormDto", new AdminFormDto() );
        return "giftList";
    }


}
