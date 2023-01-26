package com.tekup.RentCar.service;

import com.tekup.RentCar.entity.User;
import com.tekup.RentCar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository clientRepository;
    public User signUp(User c){
        clientRepository.save(c);
        return c;
    }

    public List<User> getAllUsers(){

        return clientRepository.findAll();
    }

    public List<User> getAllClients(){
        return clientRepository.getAllClients();
    }


    public User getClientById(int id){
        return clientRepository.findById(id).get();
    }

    public void deleteById(int id) {
        clientRepository.deleteById(id);
    }
}
