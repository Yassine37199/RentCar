package com.tekup.RentCar.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numLocation;
    private LocalDate dateLocation;
    private LocalDate dateRetour;
    private int nbJours;
    private double prix_Location;

    public Location() {
        super();
    }

    public Location(LocalDate dateLocation, LocalDate dateRetour, int nbJours, double prix_Location) {
        super();
        this.dateLocation = dateLocation;
        this.dateRetour = dateRetour;
        this.nbJours = nbJours;
        this.prix_Location = prix_Location;
    }

    public int getNumLocation() {
        return numLocation;
    }

    public void setNumLocation(int numLocation) {
        this.numLocation = numLocation;
    }

    public LocalDate getDateLocation() {
        return dateLocation;
    }

    public void setDateLocation(LocalDate dateLocation) {
        this.dateLocation = dateLocation;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(LocalDate dateRetour) {
        this.dateRetour = dateRetour;
    }

    public int getNbJours() {
        return nbJours;
    }

    public void setNbJours(int nbJours) {
        this.nbJours = nbJours;
    }

    public double getPrix_Location() {
        return prix_Location;
    }

    public void setPrix_Location(double prix_Location) {
        this.prix_Location = prix_Location;
    }

    @Override
    public String toString() {
        return "Location{" +
                "numLocation=" + numLocation +
                ", dateLocation=" + dateLocation +
                ", dateRetour=" + dateRetour +
                ", nbJours=" + nbJours +
                ", prix_Location=" + prix_Location +
                '}';
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "numUser", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)



    private SignedUser user;

    public SignedUser getUser() {
        return user;
    }

    public void setUser (SignedUser user) {
        this.user=user;
    }


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)



    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar (Car car) {
        this.car=car;
    }
}
