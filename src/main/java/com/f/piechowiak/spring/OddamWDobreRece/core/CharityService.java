package com.f.piechowiak.spring.OddamWDobreRece.core;

import com.f.piechowiak.spring.OddamWDobreRece.dto.CharityFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.models.Charity;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.CharityRepository;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.GiftTypeReposiotry;
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
    @Autowired
    private GiftTypeReposiotry giftTypeReposiotry;

    public CharityService(CharityRepository charityRepository, GiftTypeReposiotry giftTypeReposiotry) {
        this.charityRepository = charityRepository;
        this.giftTypeReposiotry = giftTypeReposiotry;
    }


    @Transactional
    public boolean createOrganization(CharityFormDto form) {
        Charity org = new Charity();

        org.setCharityName( form.getCharityName() );
        org.setCity( form.getCity() );
        org.setCharityActivityType( form.getCharityActivityType() );
        org.setAcceptedGiftTypes( form.getAcceptedGiftTypes() );
        org.setCharityStructureType( form.getCharityStructureType() );
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
    @Transactional
    public boolean updateCharityByAdmin(CharityFormDto form) {
        Charity org = new Charity();

        org.setId( form.getId() );
        org.setCharityName( form.getCharityName() );
        org.setCity( form.getCity() );
        org.setCharityActivityType( form.getCharityActivityType() );
        org.setAcceptedGiftTypes( form.getAcceptedGiftTypes() );
        org.setCharityStructureType( form.getCharityStructureType() );
        org = charityRepository.save( org );

        return true;
    }


    public CharityFormDto findCharityByIdAndFill(Long id) {
        CharityFormDto charityFormDto = new CharityFormDto();
        Charity org = charityRepository.findById( id ).orElse( null );

        if (org != null) {
            charityFormDto.setId( org.getId() );
            charityFormDto.setCharityName( org.getCharityName() );
            charityFormDto.setCity( org.getCity() );
            charityFormDto.setCharityActivityType( org.getCharityActivityType() );
            charityFormDto.setCharityStructureType( org.getCharityStructureType() );
            charityFormDto.setAcceptedGiftTypes( giftTypeReposiotry.getAcceptedGiftsByCharityId(id) );     //new query trial
        }

        return charityFormDto;
    }

}
