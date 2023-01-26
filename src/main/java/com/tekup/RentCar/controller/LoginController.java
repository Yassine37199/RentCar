package com.tekup.RentCar.controller;

import com.tekup.RentCar.entity.User;
import com.tekup.RentCar.entity.SignedUser;
import com.tekup.RentCar.repository.UserRepository;
import com.tekup.RentCar.repository.SignedUserRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserRepository clientRepository;

    @Autowired
    private SignedUserRepsitory signedClientRepsitory;

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/signin")
    public String loginClient(@ModelAttribute User c){
        User user = clientRepository.getClientByMail(c.getMail());
        if(user != null){
            if(c.getPassword().equals(user.getPassword())){
                SignedUser sc = new SignedUser(user.getNumUser(), user.getNom(), user.getPrenom(), user.getAdresse(), user.getNumTel(), user.getMail(), user.getPassword(), user.getRole());
                this.signedClientRepsitory.save(sc);
                return "redirect:/";
            }
            else return "redirect:/login";
        }
        else return "redirect:/login";
    }

    @GetMapping("/register")
    public String registerPage(){
        return "registerUser";
    }

    @PostMapping("/saveClient")
    public String registerClient(@ModelAttribute User c){
        c.setRole("client");
        clientRepository.save(c);
        SignedUser sc = new SignedUser(c.getNumUser(), c.getNom(), c.getPrenom(), c.getAdresse(), c.getNumTel(), c.getMail(), c.getPassword(), c.getRole() );
        this.signedClientRepsitory.save(sc);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(){
        signedClientRepsitory.deleteAll();
        return "redirect:/login";
    }



}
