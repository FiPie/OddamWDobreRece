package com.f.piechowiak.spring.OddamWDobreRece.repositories;

import com.f.piechowiak.spring.OddamWDobreRece.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<User, Long> {



}
