package com.tekup.RentCar.service;

import com.tekup.RentCar.entity.MyCarList;
import com.tekup.RentCar.repository.MyCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyCarListService {
    @Autowired
    private MyCarRepository mycar;

    public void saveMyCar(MyCarList car){
        mycar.save(car);
    }

    public List<MyCarList>getAllmyCars(){
        return mycar.findAll();
    }

    public void deleteById(int id){
        mycar.deleteById(id);
    }

}
