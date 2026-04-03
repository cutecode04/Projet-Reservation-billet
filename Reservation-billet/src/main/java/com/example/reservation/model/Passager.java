package com.example.reservation.model;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Passager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numPasseport;
    private String nomComplet;
    private String email;
    private int valises;
    // Relation : un passager peut avoir plusieurs billets
    @OneToMany(mappedBy = "passager", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Billet> billets;
    // Relation : un passager peut avoir plusieurs réservations
    @OneToMany(mappedBy = "passager", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Reservation> reservations;
    // Constructeur vide obligatoire
    public Passager() {
    }
    // Constructeur
    public Passager(int numPasseport, String nomComplet, String email, int valises) {
        this.numPasseport = numPasseport;
        this.nomComplet = nomComplet;
        this.email = email;
        this.valises = valises;
    }
    // Getters et Setters
    public Long getId() {
        return id;
    }
    public int getNumPasseport() {
        return numPasseport;
    }
    public void setNumPasseport(int numPasseport) {
        this.numPasseport = numPasseport;
    }
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        if (nomComplet == null || nomComplet.isEmpty()) {
            System.out.println("Nom invalide !");
        } else {
            this.nomComplet = nomComplet;
        }
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            System.out.println("Email invalide !");
        } else {
            this.email = email;
        }
    }
    public int getValises() {
        return valises;
    }
    public void setValises(int valises) {
        if (valises < 0) {
            System.out.println("Nombre de valises invalide !");
        } else {
            this.valises = valises;
        }
    }
    public List<Billet> getBillets() {
        return billets;
    }
    public void setBillets(List<Billet> billets) {
        this.billets = billets;
    }
    public List<Reservation> getReservations() {
        return reservations;
    }
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    // Méthode métier
    public void ajouterBagage(int nb) {
        if (nb > 0) {
            this.valises += nb;
        }
    }
    @Override
    public String toString() {
        return "Passager{" +
                "id=" + id +
                ", numPasseport=" + numPasseport +
                ", nomComplet='" + nomComplet + '\'' +
                ", email='" + email + '\'' +
                ", valises=" + valises +
                '}';
    }
}
