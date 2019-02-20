package com.f.piechowiak.spring.OddamWDobreRece.core;

import com.f.piechowiak.spring.OddamWDobreRece.dto.AdminFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.dto.RegistrationFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.models.User;
import com.f.piechowiak.spring.OddamWDobreRece.models.UserRole;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.UserRepository;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService {

    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRoleRepository userRoleRepository;

    public AdminService (UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Transactional
    public boolean createAdmin(AdminFormDto form){
        User user = new User();
        user.setEmail( form.getEmail() );
        user.setFirstName( form.getFirstName() );
        user.setLastName( form.getLastName() );
        user.setEnabled( true );
        String encodedPassword = passwordEncoder.encode( form.getPassword() );
        user.setPassword( encodedPassword );
        user = userRepository.save(user);

        UserRole userRole = new UserRole();
        userRole.setUser( user );
        userRole.setRole( "ROLE_ADMIN" );
        userRole = userRoleRepository.save( userRole );

        return true;
    }







}
