package com.f.piechowiak.spring.OddamWDobreRece.repositories;

import com.f.piechowiak.spring.OddamWDobreRece.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    @Query(value = "SELECT * FROM users JOIN users_roles ON users.id=users_roles.user_id WHERE users_roles.roles='ROLE_USER'", nativeQuery = true)
    List<User> getUserList();

    @Override
    List<User> findAll();
}
