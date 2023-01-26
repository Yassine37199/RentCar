package com.tekup.RentCar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SignedUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numClt;
    private String nom;
    private String prenom;
    private String adresse;
    private String numTel;
    private String mail;
    private String password;
    private String role;

    public SignedUser() {

    }

    public SignedUser(int numClt, String nom, String prenom, String adresse, String numTel, String mail, String password, String role) {
        super();
        this.numClt = numClt;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.mail = mail;
        this.password = password;
        this.numTel = numTel;
        this.role = role;
    }

    public int getNumClt() {
        return numClt;
    }

    public void setNumClt(int numClt) {
        this.numClt = numClt;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "numClt=" + numClt +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", numTel='" + numTel + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
