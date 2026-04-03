package com.example.reservation.model;

import jakarta.persistence.*;

@Entity
public class Aeroport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAeroport;

    private String nom;
    private String ville;
    private String pays;

    // Constructeur vide obligatoire pour JPA
    public Aeroport() {
    }

    // Constructeur avec paramètres
    public Aeroport(String nom, String ville, String pays) {
        this.nom = nom;
        this.ville = ville;
        this.pays = pays;
    }

    // Getters et Setters

    public Long getIdAeroport() {
        return idAeroport;
    }

    public void setIdAeroport(Long idAeroport) {
        this.idAeroport = idAeroport;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        return "Aeroport{" +
                "id=" + idAeroport +
                ", nom='" + nom + '\'' +
                ", ville='" + ville + '\'' +
                ", pays='" + pays + '\'' +
                '}';
    }
}
