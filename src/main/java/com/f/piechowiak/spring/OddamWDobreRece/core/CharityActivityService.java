package com.f.piechowiak.spring.OddamWDobreRece.core;


import com.f.piechowiak.spring.OddamWDobreRece.dto.CharityActivityDto;
import com.f.piechowiak.spring.OddamWDobreRece.models.CharityActivity;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.CharityActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CharityActivityService {


    @Autowired
    private CharityActivityRepository charityActivityRepository
            ;

    public CharityActivityService(CharityActivityRepository charityActivityRepository
    ) {
        this.charityActivityRepository
                = charityActivityRepository
        ;
    }

    @Transactional
    public boolean createCharityActivity(CharityActivityDto form){
        CharityActivity charityActivity = new CharityActivity();
        charityActivity.setOrganizationActivity( form.getOrganizationActivity() );
        charityActivity = charityActivityRepository
                .save( charityActivity );
        return true;
    }

    @Transactional
    public boolean deleteCharityActivity(Long id){
        CharityActivity charityActivity = new CharityActivity();
        charityActivity.setId( id );
        if (charityActivityRepository
                .findById( charityActivity.getId() ) != null){
            charityActivityRepository
                    .deleteById( charityActivity.getId() );
        }
        return true;
    }

    @Transactional
    public boolean updateCharityActivity(CharityActivityDto form){
        CharityActivity charityActivity = new CharityActivity();

        charityActivity.setId( form.getId() );
        charityActivity.setOrganizationActivity( form.getOrganizationActivity() );
        charityActivity = charityActivityRepository
                .save( charityActivity );
        return true;
    }

    public CharityActivityDto findCharityActivityByIdAndFill(Long id){
        CharityActivityDto charityActivityDto
                = new CharityActivityDto();
        CharityActivity charityActivity = charityActivityRepository
                .findById( id ).orElse( null );

        if (charityActivity != null){
            charityActivityDto.setId( charityActivity.getId() );
            charityActivityDto
                    .setOrganizationActivity( charityActivity.getOrganizationActivity() );
        }
        return charityActivityDto;
    }




}
