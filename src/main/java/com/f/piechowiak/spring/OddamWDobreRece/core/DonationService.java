package com.f.piechowiak.spring.OddamWDobreRece.core;

import com.f.piechowiak.spring.OddamWDobreRece.dto.CharityFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.dto.DonationDto;
import com.f.piechowiak.spring.OddamWDobreRece.dto.GiftFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.models.Charity;
import com.f.piechowiak.spring.OddamWDobreRece.models.Donation;
import com.f.piechowiak.spring.OddamWDobreRece.models.GiftType;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.CharityRepository;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.DonationRepository;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.GiftTypeReposiotry;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class DonationService {


    @Autowired
    DonationRepository donationRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CharityRepository charityRepository;
    @Autowired
    GiftTypeReposiotry giftTypeReposiotry;
    @Autowired
    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }


    @Transactional
    public boolean createDonation(DonationDto form) {
        Donation donation = new Donation();

        donation.setCreationDate( LocalDateTime.now() );        //recent change
        donation.setQuantity( form.getQuantity() );
        donation.setGiftTypeList( form.getGiftTypeList() );
        donation.setUser( form.getUser() );
        donation.setCharity( form.getCharity() );
        donation.setGiftPickedUp( form.isGiftPickedUp() );
        donation.setPickUpDate( form.getPickUpDate() );
        donation.setPickUpHour( form.getPickUpHour() );
        donation.setStatusChangeDate( LocalDateTime.now() );    //recent change
        donation.setCity( form.getCity() );
        donation.setStreet( form.getStreet() );
        donation.setPostCode( form.getPostCode() );
        donation.setPhone( form.getPhone() );
        donation.setNotes( form.getNotes() );
        donationRepository.save( donation );

        return true;
    }

    @Transactional
    public boolean delete(Long id) {
        Donation org = new Donation();

        org.setId( id );
        if (donationRepository.findById( org.getId() ) != null) {
            donationRepository.deleteById( org.getId() );
        }

        return true;
    }

    @Transactional
    public boolean updateDonation(DonationDto form){
        Donation donation = new Donation();

        donation.setId( form.getId() );
        donation.setQuantity( form.getQuantity() );
        donation.setGiftTypeList( form.getGiftTypeList() );
        donation.setUser( form.getUser() );
        donation.setCharity( form.getCharity() );
        donation.setGiftPickedUp( form.isGiftPickedUp() );
        donation.setPickUpDate( form.getPickUpDate() );
        donation.setPickUpHour( form.getPickUpHour() );
        donation.setCity( form.getCity() );
        donation.setStreet( form.getStreet() );
        donation.setPostCode( form.getPostCode() );
        donation.setPhone( form.getPhone() );
        donation.setStatusChangeDate( LocalDateTime.now());     //recent change
        donation.setNotes( form.getNotes() );
        donation = donationRepository.save( donation );

        return true;
    }
     public DonationDto findDonationByIdAndFillDonationDto(Long id){
        DonationDto donationDto = new DonationDto();
        Donation donation = donationRepository.findById( id ).orElse( null );

        if (donation != null){
            donationDto.setId( donation.getId() );
            donationDto.setQuantity( donation.getQuantity() );
            donationDto.setGiftTypeList( donation.getGiftTypeList() );
            donationDto.setUser( donation.getUser() );
            donationDto.setCharity( donation.getCharity() );
            donationDto.setGiftPickedUp( donation.isGiftPickedUp() );
            donationDto.setPickUpDate( donation.getPickUpDate() );
            donationDto.setPickUpHour( donation.getPickUpHour() );
            donationDto.setCity( donation.getCity() );
            donationDto.setStreet( donation.getStreet() );
            donationDto.setPostCode( donation.getPostCode() );
            donationDto.setPhone( donation.getPhone() );
            donationDto.setStatusChangeDate( donation.getStatusChangeDate() );
            donationDto.setNotes( donation.getNotes() );
        }

        return donationDto;
     }

    public DonationDto fillPartiallyDonationDto(DonationDto form){
        DonationDto donationDtoToFill = new DonationDto();

        if (form.getQuantity()!=null){donationDtoToFill.setQuantity( form.getQuantity() );}

        if (form.getGiftTypeList()!=null){donationDtoToFill.setGiftTypeList( form.getGiftTypeList() );}
        if (form.getUser()!=null){donationDtoToFill.setUser( form.getUser() );}
        if (form.getCharity()!=null){donationDtoToFill.setCharity( form.getCharity() );}
        if (form.getPickUpDate()!=null){donationDtoToFill.setPickUpDate( form.getPickUpDate() );}
        if (form.getPickUpHour()!=null){donationDtoToFill.setPickUpHour( form.getPickUpHour() );}
        if (form.getCity()!=null){donationDtoToFill.setCity( form.getCity() );}
        if (form.getStreet()!=null){donationDtoToFill.setStreet( form.getStreet() );}
        if (form.getPostCode()!=null){donationDtoToFill.setPostCode( form.getPostCode() );}
        if (form.getPhone()!=null){donationDtoToFill.setPhone( form.getPhone() );}
        if (form.getNotes()!=null){donationDtoToFill.setNotes( form.getNotes() );}


        return donationDtoToFill;
    }

}
