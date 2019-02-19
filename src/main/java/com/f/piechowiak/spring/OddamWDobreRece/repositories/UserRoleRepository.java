package com.f.piechowiak.spring.OddamWDobreRece.repositories;


import com.f.piechowiak.spring.OddamWDobreRece.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {



    List<UserRole> findAllByUserId(Long id);

    List<UserRole> findAllByRoleContaining(String role);

}
