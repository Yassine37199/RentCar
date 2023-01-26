package com.tekup.RentCar.controller;

import com.tekup.RentCar.entity.Car;
import com.tekup.RentCar.entity.Location;
import com.tekup.RentCar.entity.MyCarList;
import com.tekup.RentCar.entity.SignedUser;
import com.tekup.RentCar.repository.LocationRepository;
import com.tekup.RentCar.repository.SignedUserRepsitory;
import com.tekup.RentCar.service.CarService;
import com.tekup.RentCar.service.MyCarListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.*;

@Controller
public class CarController {

    @Autowired
    private CarService service;
    @Autowired
    private MyCarListService myCarListService;
    @Autowired
    private SignedUserRepsitory signedClientRepsitory;
    @Autowired
    private LocationRepository locationRepository;


    @GetMapping("/")
    public ModelAndView home(){
        List<SignedUser> signedClients = signedClientRepsitory.findAll();
        if(signedClients.isEmpty()) {
            return new ModelAndView("redirect:/login");
        }
        else {
            SignedUser user = signedClients.get(0);
            return new ModelAndView("home" , "user" , user);
        }

    }

    @GetMapping("/car_register")
    public ModelAndView CarRegister(){
        List<SignedUser> signedClients = signedClientRepsitory.findAll();
        SignedUser user = signedClients.get(0);
        return new ModelAndView("carRegister" , "user", user );
    }
    @GetMapping("/available_car")
    public ModelAndView getAllcars(Model model){
        List<Car> list=service.getAllcars();
       // ModelAndView m=new ModelAndView();
       // m.setViewName("CarList");
        //m.addObject("Car",list);
        List<SignedUser> signedClients = signedClientRepsitory.findAll();
        SignedUser user = signedClients.get(0);
        model.addAttribute("car" , list);
        model.addAttribute("user" , user);
        return new ModelAndView("carList");
    }

    @PostMapping("/save")
    public String addCar(@ModelAttribute Car c){
        service.save(c);
        return "redirect:/available_car";
    }

    @GetMapping("/my_cars")
    public String getMyCars(Model model){
        List<SignedUser> signedClients = signedClientRepsitory.findAll();
        SignedUser user = signedClients.get(0);
        List<MyCarList>list=myCarListService.getAllmyCars();
        model.addAttribute("car",list);
        model.addAttribute("user",user);
       return "mycars";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
        Car c=service.getCarById(id);
        MyCarList nb=new MyCarList(c.getId(),c.getMarque(),c.getModele(),c.getCouleur(),c.getPrice());
        myCarListService.saveMyCar(nb);
        return "redirect:/my_cars";
    }

    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") int id){
        myCarListService.deleteById(id);
        return "redirect:/my_cars";
    }


    @RequestMapping("reserver/{idClient}/{idCar}")
    public String reserverCar(@PathVariable("idClient") int numUser ,
                              @PathVariable("idCar") int idCar ) {
        SignedUser user = signedClientRepsitory.findAll().get(0);
        Car car = service.getCarById(idCar);
        Location location = new Location(LocalDate.now() , LocalDate.now().plusDays(6) , 6 , (double)7500);
        location.setUser(user);
        location.setCar(car);
        this.locationRepository.save(location);
        return "redirect:/my_reservations";
    }
}
