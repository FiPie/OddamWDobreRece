package com.f.piechowiak.spring.OddamWDobreRece.repositories;

import com.f.piechowiak.spring.OddamWDobreRece.models.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiftReposiotry extends JpaRepository<Gift, Long> {

    @Query(value = "SELECT * FROM gift_types JOIN charity_gift_type ON gift_types.id = charity_gift_type.gift_type_id WHERE charity_gift_type.charity_id = ?", nativeQuery = true)
    List<Gift> getAcceptedGiftsByCharityId(Long id);
}
