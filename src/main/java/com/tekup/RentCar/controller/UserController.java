package com.tekup.RentCar.controller;

import com.tekup.RentCar.entity.SignedUser;
import com.tekup.RentCar.entity.User;
import com.tekup.RentCar.repository.SignedUserRepsitory;
import com.tekup.RentCar.repository.UserRepository;
import com.tekup.RentCar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Scanner;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private SignedUserRepsitory signedUserRepsitory;

    @GetMapping("/client_register")
    public String clientRegister(){
        return "clientRegister";
    }

    @GetMapping("/clients")
    public String getAllClients(Model model){
        List<User> list = userService.getAllClients();
        // ModelAndView m=new ModelAndView();
        // m.setViewName("CarList");
        //m.addObject("Car",list);


        List<SignedUser> signedClients = signedUserRepsitory.findAll();
        SignedUser user = signedClients.get(0);
        model.addAttribute("clients" , list);
        model.addAttribute("user" , user);

        return "clientList";
    }

    @PostMapping("/register")
    public String signUp(@ModelAttribute User c){
        c.setRole("client");
        c.toString();
        userService.signUp(c);
        return "redirect:/";
    }

    @DeleteMapping("/deleteMyList/{id}")
    public String deleteClient(@PathVariable("id") int id){
        userService.deleteById(id);
        return "redirect:/clients";
    }
}
