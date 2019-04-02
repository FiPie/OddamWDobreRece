package com.f.piechowiak.spring.OddamWDobreRece.repositories;

import com.f.piechowiak.spring.OddamWDobreRece.models.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query(value = "SELECT SUM(quantity) FROM donations WHERE user_id=?", nativeQuery = true)
        //returns total quantity of bags donated by the User
    Long sumBagsQuantityForUserId(Long userId);

    @Query(value = "SELECT COUNT(DISTINCT donations.charity_id) FROM donations WHERE user_id=?", nativeQuery = true)
        //returns distinct number of charities supported by the User (each occurence charity is counted only once)
    Long sumOfSupportedCharitiesByUserId(Long userId);

    @Query(value = "SELECT COUNT(*) FROM donations WHERE user_id=?", nativeQuery = true)
        //returns total number of donations made by given User
    Long sumOfDonationsMadeByUserId(Long userId);

    @Query(value = "SELECT * FROM donations WHERE user_id=? ORDER BY gift_picked_up, pick_up_date, creation_date ", nativeQuery = true)
        //returns user's list of donations by user id
    List<Donation> findAllDonationsByUserId(Long userId);

    @Query(value = "SELECT SUM(quantity) FROM donations", nativeQuery = true)
        //returns sum of all bags given away as donations to charities by all users
    Long sumAllBagsGivenToCharities();

    @Query(value = "SELECT COUNT(DISTINCT donations.charity_id) FROM donations", nativeQuery = true)
        //returns number of charity organizations supported by donations (each occurence of charity is counted only once)
    Long countAllCharitiesDonatedTo();

    @Query(value = "SELECT COUNT(*) FROM donations", nativeQuery = true)
        //returns number of donations made by all users
    Long countAllDonations();

}
