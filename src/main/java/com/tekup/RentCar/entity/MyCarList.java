package com.tekup.RentCar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Mycars")
public class MyCarList {
    @Id
    private int id;
    private String marque;
    private String modele;
    private String couleur;
    private String price;

    public MyCarList(int id, String marque, String modele, String couleur, String price) {
        super();
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
        this.price = price;
    }
    public MyCarList(){
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
