package com.f.piechowiak.spring.OddamWDobreRece.core;

import com.f.piechowiak.spring.OddamWDobreRece.dto.AdminFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.dto.UserFormDto;
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
public class UserService {

    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRoleRepository userRoleRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Transactional
    public boolean update(UserFormDto form){

        User user = new User();

        user.setEmail( form.getEmail() );
        user.setFirstName( form.getFirstName() );
        user.setLastName( form.getLastName() );
        String encodedPassword = passwordEncoder.encode( form.getPassword() );
        user.setPassword( encodedPassword);
        user = userRepository.save( user );

        return true;
    }

    @Transactional
    public boolean delete(UserFormDto form){
        User user = new User();
        user.setId( form.getId() );
        if (userRepository.findById( user.getId()) != null){
            userRepository.deleteById( user.getId() );
        }

        return true;
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
    @Transactional
    public boolean updateAdmin(AdminFormDto form){
        User user = new User();

        user.setId( form.getId() );
        user.setEmail( form.getEmail() );
        user.setFirstName( form.getFirstName() );
        user.setLastName( form.getLastName() );
        user.setEnabled( form.isEnabled() );
        String encodedPassword = passwordEncoder.encode( form.getPassword() );
        user.setPassword( encodedPassword );
        user = userRepository.save(user);


        return true;
    }

    @Transactional
    public boolean deleteAdmin(AdminFormDto form){
        User user = new User();
        user.setId( form.getId() );
        if (userRepository.findById( user.getId()) != null){
            userRepository.deleteById( user.getId() );
        }

        return true;
    }


    public AdminFormDto findByIdAndFill(Long id){
        AdminFormDto adminFormDto = new AdminFormDto();
        User user = userRepository.findById( id ).orElse( null );

        if (user != null){
            adminFormDto.setId( user.getId() );
            adminFormDto.setEmail( user.getEmail() );
            adminFormDto.setFirstName( user.getFirstName() );
            adminFormDto.setLastName( user.getLastName() );
            adminFormDto.setPassword( user.getPassword() );
            adminFormDto.setConfirmedPassword( user.getPassword() );
            adminFormDto.setEnabled( user.isEnabled() );
        }

        return adminFormDto;
    }

















}
