package com.tekup.RentCar.repository;

import com.tekup.RentCar.entity.MyCarList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyCarRepository extends JpaRepository<MyCarList,Integer> {
}
