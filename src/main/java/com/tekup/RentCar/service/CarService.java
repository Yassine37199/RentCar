package com.tekup.RentCar.service;

import com.tekup.RentCar.entity.Car;
import com.tekup.RentCar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    public void save(Car c){
        carRepository.save(c);
    }

    public List<Car> getAllcars(){
        return carRepository.findAll();
    }

    public Car getCarById(int id){
        return carRepository.findById(id).get();
    }
}
