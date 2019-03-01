package com.f.piechowiak.spring.OddamWDobreRece.core;


import com.f.piechowiak.spring.OddamWDobreRece.dto.CharityTypeDto;
import com.f.piechowiak.spring.OddamWDobreRece.models.CharityType;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.CharityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CharityTypeService {

    @Autowired
        private CharityTypeRepository charityTypeRepository
            ;

        public CharityTypeService(CharityTypeRepository charityTypeRepository
    ) {
        this.charityTypeRepository
                = charityTypeRepository
        ;
    }

    @Transactional
    public boolean createCharityType(CharityTypeDto form){
        CharityType charityType = new CharityType();
        charityType.setOrganizationType( form.getOrganizationType() );
        charityType = charityTypeRepository
                .save( charityType );
        return true;
    }

    @Transactional
    public boolean deleteCharityType(Long id){
        CharityType charityType = new CharityType();
        charityType.setId( id );
        if (charityTypeRepository
                .findById( charityType.getId() ) != null){
            charityTypeRepository
                    .deleteById( charityType.getId() );
        }
        return true;
    }

    @Transactional
    public boolean updateCharityType(CharityTypeDto form){
        CharityType charityType = new CharityType();

        charityType.setId( form.getId() );
        charityType.setOrganizationType( form.getOrganizationType() );
        charityType = charityTypeRepository
                .save( charityType );
        return true;
    }

    public CharityTypeDto findCharityTypeByIdAndFill(Long id){
        CharityTypeDto charityTypeDto
                = new CharityTypeDto();
        CharityType charityType = charityTypeRepository
                .findById( id ).orElse( null );

        if (charityType != null){
            charityTypeDto.setId( charityType.getId() );
            charityTypeDto
                    .setOrganizationType( charityType.getOrganizationType() );
        }
        return charityTypeDto;
    }


}
