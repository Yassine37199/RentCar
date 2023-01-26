package com.tekup.RentCar.controller;

import com.tekup.RentCar.entity.Location;
import com.tekup.RentCar.entity.MyCarList;
import com.tekup.RentCar.entity.SignedUser;
import com.tekup.RentCar.repository.LocationRepository;
import com.tekup.RentCar.repository.SignedUserRepsitory;
import com.tekup.RentCar.service.MyCarListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LocationController {

    @Autowired
    private SignedUserRepsitory signedUserRepsitory;

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping("/my_reservations")
    public String getMyReservations(Model model){
        List<SignedUser> signedClients = signedUserRepsitory.findAll();
        SignedUser user = signedClients.get(0);
        List<Location>list= locationRepository.getMyReservations(user.getMail());
        model.addAttribute("locations",list);
        model.addAttribute("user" , user);
        return "locations";
    }
}
