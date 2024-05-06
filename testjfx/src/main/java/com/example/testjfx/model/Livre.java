package com.example.testjfx.model;

import javafx.scene.image.Image;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String titre;
    private String ISBN;
    private String auteur;
    private int anneePublication;
    private int nombrePages;
    private String quatriemeDeCouverture;
    private Image imageCouverture;
    private String cheminImageCouverture;


    public Livre(String titre, String ISBN, String auteur, int anneePublication, int nombrePages, String quatriemeDeCouverture) {
        this.titre = titre;
        this.ISBN = ISBN;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.nombrePages = nombrePages;
        this.quatriemeDeCouverture = quatriemeDeCouverture;
//        this.imageCouverture = getImageCouverture();
    }



    public String getCheminImageCouverture() {
        return cheminImageCouverture;
    }

    public void setCheminImageCouverture(String cheminImageCouverture) {
        this.cheminImageCouverture = cheminImageCouverture;
    }

    // Méthode pour charger l'image de couverture en tant qu'objet Image
//    public Image getImageCouverture() {
//
//    }

    public Livre() {
    }

    // Getters/setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getAnneePublication() {
        return anneePublication;
    }

    public void setAnneePublication(int anneePublication) {
        this.anneePublication = anneePublication;
    }

    public int getNombrePages() {
        return nombrePages;
    }

    public void setNombrePages(int nombrePages) {
        this.nombrePages = nombrePages;
    }

    public String getQuatriemeDeCouverture() {
        return quatriemeDeCouverture;
    }

    @Override
    public String toString() {
        // Utilisé par ListView pour afficher le titre du livre
        return getTitre();
    }
}
