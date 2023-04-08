package com.erturk.dao.inter;

import com.erturk.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);
    User findByNameAndSurname(String name, String surname);
    @Query(value = "select u from User u where u.surname = :surname")
    List<User> findBySurname(@Param("surname") String surname);
    @Query(value = "select u from User u where u.email = ?1")
    User findByEmail(String email);
}
