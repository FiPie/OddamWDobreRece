package com.f.piechowiak.spring.OddamWDobreRece.core;

import com.f.piechowiak.spring.OddamWDobreRece.dto.GiftFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.models.Gift;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.CharityRepository;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.GiftReposiotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GiftService {

    @Autowired
    private GiftReposiotry giftReposiotry;

    public GiftService(GiftReposiotry giftReposiotry) {
        this.giftReposiotry = giftReposiotry;
    }

    @Transactional
    public boolean createGiftType(GiftFormDto form){
        Gift gift = new Gift();

        gift.setGiftType( form.getGiftType() );
        gift = giftReposiotry.save( gift );

        return true;
    }


}
