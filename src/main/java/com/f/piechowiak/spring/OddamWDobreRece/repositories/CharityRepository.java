package com.f.piechowiak.spring.OddamWDobreRece.repositories;

import com.f.piechowiak.spring.OddamWDobreRece.models.Charity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharityRepository extends JpaRepository<Charity, Long> {

    @Query(value = "SELECT * FROM charities", nativeQuery = true)
    List<Charity> getCharityList();

    @Query(value = "SELECT DISTINCT city FROM charities ORDER BY city", nativeQuery = true)
    List<String> getCityList();

    /*@Query(value = "SELECT * FROM gifts JOIN charity_gift_type ON gifts.id = charity_gift_type.gift_type_id WHERE charity_gift_type.charity_id = ?", nativeQuery = true)
    List<GiftType> getAcceptedGiftsByCharityId(Long id);        //new query to get AcceptedGifts List by charity id*/

    //SELECT DISTINCT colorName FROM mytable ORDER BY colorName

    /*@Query(value = "SELECT * FROM users JOIN users_roles ON users.id=users_roles.user_id WHERE users_roles.roles='ROLE_USER'", nativeQuery = true)
    List<User> getUserList();*/
}
