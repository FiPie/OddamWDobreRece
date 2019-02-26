package com.f.piechowiak.spring.OddamWDobreRece.repositories;

import com.f.piechowiak.spring.OddamWDobreRece.models.Charity;
import com.f.piechowiak.spring.OddamWDobreRece.models.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharityRepository extends JpaRepository<Charity, Long> {

    @Query(value = "SELECT * FROM charities", nativeQuery = true)
    List<Charity> getCharityList();

    @Query(value = "SELECT * FROM gifts JOIN charity_gift ON gifts.id = charity_gift.gift_id WHERE charity_gift.charity_id = ?", nativeQuery = true)
    List<Gift> getAcceptedGiftsByCharityId(Long id);        //new query to get AcceptedGifts List by charity id



    /*@Query(value = "SELECT * FROM users JOIN users_roles ON users.id=users_roles.user_id WHERE users_roles.roles='ROLE_USER'", nativeQuery = true)
    List<User> getUserList();*/
}
