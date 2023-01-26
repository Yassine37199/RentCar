package com.tekup.RentCar.repository;

import com.tekup.RentCar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u " +
            "WHERE u.mail = ?1")
    User getClientByMail(String mail);

    @Query("SELECT u FROM User u " +
            "WHERE u.role = 'client'")
    List<User> getAllClients();
}
