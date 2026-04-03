package com.example.reservation.model;

import jakarta.persistence.*;

@Entity
public class Avion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modele;
    private int capacite;

    @ManyToOne
    @JoinColumn(name = "compagnie_id")
    private CompagnieAerienne compagnie;

    // Constructeur vide obligatoire
    public Avion() {
    }

    // Constructeur
    public Avion(String modele, int capacite, CompagnieAerienne compagnie) {
        this.modele = modele;
        this.capacite = capacite;
        this.compagnie = compagnie;
    }

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public CompagnieAerienne getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(CompagnieAerienne compagnie) {
        this.compagnie = compagnie;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "id=" + id +
                ", modele='" + modele + '\'' +
                ", capacite=" + capacite +
                '}';
    }
}