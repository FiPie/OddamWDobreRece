package com.f.piechowiak.spring.OddamWDobreRece.repositories;

import com.f.piechowiak.spring.OddamWDobreRece.models.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiftReposiotry extends JpaRepository<Gift, Long> {

    @Query(value = "SELECT * FROM gifts JOIN charity_gift ON gifts.id = charity_gift.gift_id WHERE charity_gift.charity_id = ?", nativeQuery = true)
    List<Gift> getAcceptedGiftsByCharityId(Long id);
}
