package com.example.reservation.model;


import jakarta.persistence.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Vol {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String villeDepart;

    private String villeArrivee;

    private String dateDepart;

    private String heureDepart;

    private String statut;

    // 🔗 Relation avec Avion

    @ManyToOne

    @JoinColumn(name = "avion_id")

    private Avion avion;

    // 🔗 Relation avec Billet

    @OneToMany(mappedBy = "vol", cascade = CascadeType.ALL)

    @JsonIgnore

    private List<Billet> billets;

    // 🔗 Relation avec Reservation

    @OneToMany(mappedBy = "vol", cascade = CascadeType.ALL)

    @JsonIgnore

    private List<Reservation> reservations;

    // Constructeur vide obligatoire

    public Vol() {

    }

    // Constructeur

    public Vol(String villeDepart, String villeArrivee, String dateDepart,

               String heureDepart, String statut, Avion avion) {

        this.villeDepart = villeDepart;

        this.villeArrivee = villeArrivee;

        this.dateDepart = dateDepart;

        this.heureDepart = heureDepart;

        this.statut = statut;

        this.avion = avion;

    }

    // Getters et Setters

    public Long getId() {

        return id;

    }

    public String getVilleDepart() {

        return villeDepart;

    }

    public void setVilleDepart(String villeDepart) {

        this.villeDepart = villeDepart;

    }

    public String getVilleArrivee() {

        return villeArrivee;

    }

    public void setVilleArrivee(String villeArrivee) {

        this.villeArrivee = villeArrivee;

    }

    public String getDateDepart() {

        return dateDepart;

    }

    public void setDateDepart(String dateDepart) {

        this.dateDepart = dateDepart;

    }

    public String getHeureDepart() {

        return heureDepart;

    }

    public void setHeureDepart(String heureDepart) {

        this.heureDepart = heureDepart;

    }

    public String getStatut() {

        return statut;

    }

    public void setStatut(String statut) {

        this.statut = statut;

    }

    public Avion getAvion() {

        return avion;

    }

    public void setAvion(Avion avion) {

        this.avion = avion;

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

    @Override

    public String toString() {

        return "Vol{" +

                "id=" + id +

                ", depart='" + villeDepart + '\'' +

                ", arrivee='" + villeArrivee + '\'' +

                ", date='" + dateDepart + '\'' +

                ", heure='" + heureDepart + '\'' +

                ", statut='" + statut + '\'' +

                '}';

    }

}

