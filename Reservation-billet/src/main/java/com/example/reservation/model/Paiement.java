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
    private String statut;
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePaiement;
    // Relation avec Reservation
    @OneToOne(mappedBy = "paiement")
    @JsonIgnore
    private Reservation reservation;
    // Constantes de statut
    public static final String EN_ATTENTE = "EN_ATTENTE";
    public static final String PAYE = "PAYE";
    public static final String REMBOURSE = "REMBOURSE";
    public static final String ANNULE = "ANNULE";
    // Constructeur vide obligatoire
    public Paiement() {
        this.datePaiement = new Date();
        this.statut = EN_ATTENTE;
    }
    // Constructeur
    public Paiement(double montant, String methode) {
        this.montant = montant;
        this.methode = methode;
        this.datePaiement = new Date();
        this.statut = EN_ATTENTE;
    }
    // Getters et Setters
    public Long getId() {
        return id;
    }
    public double getMontant() {
        return montant;
    }
    public void setMontant(double montant) {
        if (montant <= 0) {
            System.out.println("Montant invalide !");
        } else {
            this.montant = montant;
        }
    }
    public String getMethode() {
        return methode;
    }
    public void setMethode(String methode) {
        if (methode == null || methode.isEmpty()) {
            System.out.println("Méthode invalide !");
        } else {
            this.methode = methode;
        }
    }
    public String getStatut() {
        return statut;
    }
    public Date getDatePaiement() {
        return datePaiement;
    }
    public Reservation getReservation() {
        return reservation;
    }
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
    // 🔥 LOGIQUE MÉTIER (important pour ton projet)
    public void payer() {
        if (statut.equals(PAYE)) {
            System.out.println("Déjà payé !");
        } else {
            this.statut = PAYE;
            System.out.println("Paiement effectué.");
        }
    }
    public void rembourser() {
        if (statut.equals(PAYE)) {
            this.statut = REMBOURSE;
            System.out.println("Remboursement effectué.");
        } else {
            System.out.println("Impossible de rembourser.");
        }
    }
    public void annuler() {
        if (statut.equals(EN_ATTENTE)) {
            this.statut = ANNULE;
            System.out.println("Paiement annulé.");
        } else {
            System.out.println("Annulation impossible.");
        }
    }
    @Override
    public String toString() {
        return "Paiement{" +
                "id=" + id +
                ", montant=" + montant +
                ", methode='" + methode + '\'' +
                ", statut='" + statut + '\'' +
                ", datePaiement=" + datePaiement +
                '}';
    }
}
