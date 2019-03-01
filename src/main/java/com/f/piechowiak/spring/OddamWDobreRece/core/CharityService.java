package com.f.piechowiak.spring.OddamWDobreRece.core;

import com.f.piechowiak.spring.OddamWDobreRece.dto.OrgFormDto;
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
    public boolean createOrganization(OrgFormDto form) {
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
    public boolean updateCharityByAdmin(OrgFormDto form) {
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


    public OrgFormDto findCharityByIdAndFill(Long id) {
        OrgFormDto orgFormDto = new OrgFormDto();
        Charity org = charityRepository.findById( id ).orElse( null );

        if (org != null) {
            orgFormDto.setId( org.getId() );
            orgFormDto.setCharityName( org.getCharityName() );
            orgFormDto.setCity( org.getCity() );
            orgFormDto.setCharityActivityType( org.getCharityActivityType() );
            orgFormDto.setCharityStructureType( org.getCharityStructureType() );
            orgFormDto.setAcceptedGiftTypes( giftTypeReposiotry.getAcceptedGiftsByCharityId(id) );     //new query trial
        }

        return orgFormDto;
    }

}
