package com.f.piechowiak.spring.OddamWDobreRece.core;

import com.f.piechowiak.spring.OddamWDobreRece.dto.UserFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.models.User;
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
        String encodedPassword = passwordEncoder.encode( form.getPassword() );
        user.setPassword( encodedPassword);
        user = userRepository.save( user );

        return true;
    }

    @Transactional
    public boolean delete(UserFormDto form){
        User user = new User();
        user.setId( form.getId() );
        userRepository.delete( user );

        return true;
    }


}
