package com.f.piechowiak.spring.OddamWDobreRece.repositories;

import com.f.piechowiak.spring.OddamWDobreRece.models.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query(value = "SELECT SUM(quantity) FROM donations WHERE user_id=?", nativeQuery = true)       //returns total quantity of bags donated by the User
    Long sumBagsQuantityForUserId(Long userId);

    @Query(value = "SELECT COUNT(DISTINCT donations.charity_id) FROM donations WHERE user_id=?", nativeQuery = true)    //returns distinct number of charities supported by the User (each charity is counted only once)
    Long sumOfSupportedCharitiesByUserId(Long userId);

    @Query(value = "SELECT COUNT(*) FROM donations WHERE user_id=?", nativeQuery = true)    //returns total number of donations made by given User
    Long sumOfDonationsMadeByUserId(Long userId);


}
