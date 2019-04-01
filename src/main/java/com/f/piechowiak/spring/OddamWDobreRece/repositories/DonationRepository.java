package com.f.piechowiak.spring.OddamWDobreRece.repositories;

import com.f.piechowiak.spring.OddamWDobreRece.models.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query(value = "SELECT SUM(quantity) FROM donations WHERE user_id=?", nativeQuery = true)       //returns total quantity of bags donated by the User
    Long sumBagsQuantityForUserId(Long userId);

    @Query(value = "SELECT COUNT(DISTINCT donations.charity_id) FROM donations WHERE user_id=?", nativeQuery = true)    //returns distinct number of charities supported by the User (each charity is counted only once)
    Long sumOfSupportedCharitiesByUserId(Long userId);

    @Query(value = "SELECT COUNT(*) FROM donations WHERE user_id=?", nativeQuery = true)    //returns total number of donations made by given User
    Long sumOfDonationsMadeByUserId(Long userId);


    @Query(value = "SELECT * FROM donations WHERE user_id=? ORDER BY gift_picked_up, pick_up_date, creation_date ", nativeQuery = true)
    List<Donation> findAllDonationsByUserId(Long userId);



}
