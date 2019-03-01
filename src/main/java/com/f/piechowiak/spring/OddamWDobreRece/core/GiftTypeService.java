package com.f.piechowiak.spring.OddamWDobreRece.core;

import com.f.piechowiak.spring.OddamWDobreRece.dto.GiftFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.models.GiftType;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.GiftTypeReposiotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GiftTypeService {

    @Autowired
    private GiftTypeReposiotry giftTypeReposiotry;

    public GiftTypeService(GiftTypeReposiotry giftTypeReposiotry) {
        this.giftTypeReposiotry = giftTypeReposiotry;
    }

    @Transactional
    public boolean createGiftType(GiftFormDto form){
        GiftType giftType = new GiftType();
        giftType.setGiftType( form.getGiftType() );
        giftType = giftTypeReposiotry.save( giftType );
        return true;
    }

    @Transactional
    public boolean deleteGiftType(Long id){
        GiftType giftType = new GiftType();
        giftType.setId( id );
        if (giftTypeReposiotry.findById( giftType.getId() ) != null){
            giftTypeReposiotry.deleteById( giftType.getId() );
        }
        return true;
    }

    @Transactional
    public boolean updateGiftType(GiftFormDto form){
        GiftType giftType = new GiftType();

        giftType.setId( form.getId() );
        giftType.setGiftType( form.getGiftType() );
        giftType = giftTypeReposiotry.save( giftType );
        return true;
    }

    public GiftFormDto findGiftTypeByIdAndFill(Long id){
        GiftFormDto giftFormDto = new GiftFormDto();
        GiftType giftType = giftTypeReposiotry.findById( id ).orElse( null );

        if (giftType != null){
            giftFormDto.setId( giftType.getId() );
            giftFormDto.setGiftType( giftType.getGiftType() );
        }
        return giftFormDto;
    }

}
