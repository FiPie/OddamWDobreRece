package com.f.piechowiak.spring.OddamWDobreRece.core;

import com.f.piechowiak.spring.OddamWDobreRece.dto.AdminFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.dto.OrgFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.models.Charity;
import com.f.piechowiak.spring.OddamWDobreRece.models.UserRole;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.CharityRepository;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.UserRepository;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CharityService {

    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CharityRepository charityRepository;

    public CharityService(CharityRepository charityRepository) {
        this.charityRepository = charityRepository;
    }


    @Transactional
    public boolean createOrganization(OrgFormDto form) {
        Charity org = new Charity();

        org.setCharityName( form.getCharityName() );
        org.setCity( form.getCity() );
        org.setType( form.getType() );
        org = charityRepository.save( org );

        return true;
    }

    @Transactional
    public boolean delete(Long id) {
        Charity org = new Charity();

        org.setId( id );
        if (charityRepository.findById( org.getId() ) != null) {
            charityRepository.deleteById( org.getId() );
        }

        return true;
    }

}
