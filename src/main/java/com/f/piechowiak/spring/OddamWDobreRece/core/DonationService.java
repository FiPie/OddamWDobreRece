package com.f.piechowiak.spring.OddamWDobreRece.core;

import com.f.piechowiak.spring.OddamWDobreRece.dto.CharityFormDto;
import com.f.piechowiak.spring.OddamWDobreRece.dto.DonationDto;
import com.f.piechowiak.spring.OddamWDobreRece.models.Charity;
import com.f.piechowiak.spring.OddamWDobreRece.models.Donation;
import com.f.piechowiak.spring.OddamWDobreRece.repositories.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DonationService {


    @Autowired
    DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }


    @Transactional
    public boolean createDonation(DonationDto form) {
        Donation donation = new Donation();

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
        donation.setStatusChangeDate( form.getStatusChangeDate() );
        donation.setNotes( form.getNotes() );
        donation = donationRepository.save( donation );

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
        donation.setStatusChangeDate( form.getStatusChangeDate() );
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

}
