package com.f.piechowiak.spring.OddamWDobreRece.repositories;

import com.f.piechowiak.spring.OddamWDobreRece.models.Charity;
import com.f.piechowiak.spring.OddamWDobreRece.models.CharityActivity;
import com.f.piechowiak.spring.OddamWDobreRece.models.GiftType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CharityRepository extends JpaRepository<Charity, Long> {

    @Query(value = "SELECT * FROM charities", nativeQuery = true)
    List<Charity> getCharityList();

    @Query(value = "SELECT DISTINCT city FROM charities ORDER BY city", nativeQuery = true)
    List<String> getCityList();

    @Query(value = "SELECT * FROM charities JOIN charity_activity_type ON charity_id=charity_activity_type.charity_id WHERE charity_activity_type.charity_activity=? AND charities.city=?", nativeQuery = true)
    List<Charity> getCharityListByCityAndCharityActivityType(Long charityActivity, String city);

    @Query(value = "SELECT * FROM charities WHERE charities.city = ?", nativeQuery = true)
    List<Charity> getCharityListByCity(String city);

    @Query(value = "SELECT * FROM charities c WHERE c.charity_name LIKE'%'+?+'%'", nativeQuery = true)
    List<Charity> getCharityListByCharityName(String charityName);

    @Query(value = "SELECT charity.id from charity_activity_type WHERE charity_activity_type.charity_activity = charity_activities.id IN (?)", nativeQuery = true)
    List<Long> findAllCharityIdsMatchingActivityTypes(List<CharityActivity> ids);

    @Query(value = "SELECT * from charities WHERE charity.id IN (?)", nativeQuery = true)
    List<Charity> findAllCharitiesByIdList(List<Long> ids);





    List<Charity> findAllByIdIn(List<Long> ids);        //działa ale nie służy;)


    List<Charity> findAllByCharityActivityType_IdInAndAcceptedGiftTypesIn(List<Long> ids, List<GiftType> gifts);    //Ta działa!

    List<Charity> findByCharityActivityType_IdInAndAcceptedGiftTypesInAndCityIs(List<Long> ids, List<GiftType> gifts, String city);    //działa!
    List<Charity> findDistinctByCharityActivityType_IdInAndAcceptedGiftTypesInAndCityIs(List<Long> ids, List<GiftType> gifts, String city);    //działa!



//    Rozszerzyc DonationDto o dane do search baru


}
