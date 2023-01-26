package com.tekup.RentCar.repository;

import com.tekup.RentCar.entity.Location;
import com.tekup.RentCar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

    @Query("SELECT l FROM Location l " +
            "WHERE l.user.mail = ?1")
    List<Location> getMyReservations(String mail);
}
