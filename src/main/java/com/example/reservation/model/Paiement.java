package com.example.reservation.model;

import jakarta.persistence.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double montant;
    private String methode;

    @Enumerated(EnumType.STRING)
    private StatutPaiement statut;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datePaiement;

    @OneToOne(mappedBy = "paiement")
    @JsonIgnore
    private Reservation reservation;


    public enum StatutPaiement {
        EN_ATTENTE,
        PAYE,
        REMBOURSE,
        ANNULE
    }



    // Constructeur vide
    public Paiement() {
        this.datePaiement = new Date();
        this.statut = StatutPaiement.EN_ATTENTE;
    }

    // Constructeur
    public Paiement(double montant,  String methode, StatutPaiement statut, Date datePaiement, Reservation reservation) {
        this.montant = montant;
        this.methode = methode;
        this.statut = statut;
        this.datePaiement = datePaiement;
        this.reservation = reservation;
    }

    // GETTERS
    public Long getId() { return id; }
    public double getMontant() { return montant; }
    public String getMethode() { return methode; }
    public StatutPaiement getStatut() { return statut; }
    public Date getDatePaiement() { return datePaiement; }
    public Reservation getReservation() { return reservation; }

    // SETTERS
    public void setMontant(double montant) {
        if (montant <= 0) {
            throw new IllegalArgumentException("Montant invalide !");
        }
        this.montant = montant;
    }

    public void setMethode(String methode) {
        if (methode == null || methode.trim().isEmpty()) {
            throw new IllegalArgumentException("Méthode de paiement invalide !");
        }
        this.methode = methode;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    // Methode

    public void payer() {
        if (statut == StatutPaiement.PAYE) {
            throw new IllegalStateException("Paiement déjà effectué !");
        }
        if (statut == StatutPaiement.ANNULE) {
            throw new IllegalStateException("Paiement annulé, impossible de payer !");
        }

        this.statut = StatutPaiement.PAYE;
    }
//Methode remboursement
    public void rembourser() {
        //Si le paiement n'a pas encore été effectué impossible de faire un remboursement
        if (statut != StatutPaiement.PAYE) {
            throw new IllegalStateException("Remboursement impossible !");
        }
        //Sinon si le paiement est  effectué le remboursement peut se faire

        this.statut = StatutPaiement.REMBOURSE;
    }
//Methode annuler
    public void annuler() {
        //Si le paiement est en attente on ne peut pas annuler
        if (statut != StatutPaiement.EN_ATTENTE) {
            throw new IllegalStateException("Annulation impossible !");
        }
        //Si le paiement n'est pas en attente on annulr

        this.statut = StatutPaiement.ANNULE;
    }

    //Affichage
    @Override
    public String toString() {
        return "Paiement{" +
                "id=" + id +
                ", montant=" + montant +
                ", methode='" + methode + '\'' +
                ", statut=" + statut +
                ", datePaiement=" + datePaiement +
                '}';
    }
}