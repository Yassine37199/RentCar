package com.tekup.RentCar.repository;

import com.tekup.RentCar.entity.SignedUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignedUserRepsitory extends JpaRepository<SignedUser, Integer> {
}
