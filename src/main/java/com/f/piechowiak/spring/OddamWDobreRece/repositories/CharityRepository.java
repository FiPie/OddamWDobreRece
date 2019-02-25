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

}
