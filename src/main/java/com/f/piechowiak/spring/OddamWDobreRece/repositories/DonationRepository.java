package com.f.piechowiak.spring.OddamWDobreRece.repositories;

import com.f.piechowiak.spring.OddamWDobreRece.models.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
}
