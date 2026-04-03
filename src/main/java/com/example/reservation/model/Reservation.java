package com.example.reservation.model;

import jakarta.persistence.*;
import java.util.List;
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String statut;
    private String dateReservation;
    // 🔗 Relations principales
    @ManyToOne
    @JoinColumn(name = "passager_id")
    private Passager passager;
    @ManyToOne
    @JoinColumn(name = "vol_id")
    private Vol vol;
    @OneToOne
    @JoinColumn(name = "paiement_id")
    private Paiement paiement;
    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL)
    private Billet billet;
    // Bagages supplémentaires
    @ElementCollection
    private List<Integer> bagagesSupplementaires;
    // Statuts constants
    public static final String EN_ATTENTE = "EN_ATTENTE";
    public static final String CONFIRMEE = "CONFIRMEE";
    public static final String ANNULEE = "ANNULEE";
    // Constructeur vide obligatoire
    public Reservation() {
        this.statut = EN_ATTENTE;
    }
    // Constructeur
    public Reservation(String dateReservation, Passager passager, Vol vol) {
        this.dateReservation = dateReservation;
        this.passager = passager;
        this.vol = vol;
        this.statut = EN_ATTENTE;
    }
    // Getters et Setters
    public Long getId() {
        return id;
    }
    public String getStatut() {
        return statut;
    }
    public String getDateReservation() {
        return dateReservation;
    }
    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }
    public Passager getPassager() {
        return passager;
    }
    public void setPassager(Passager passager) {
        this.passager = passager;
    }
    public Vol getVol() {
        return vol;
    }
    public void setVol(Vol vol) {
        this.vol = vol;
    }
    public Paiement getPaiement() {
        return paiement;
    }
    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }
    public Billet getBillet() {
        return billet;
    }
    public void setBillet(Billet billet) {
        this.billet = billet;
    }
    public List<Integer> getBagagesSupplementaires() {
        return bagagesSupplementaires;
    }
    public void setBagagesSupplementaires(List<Integer> bagagesSupplementaires) {
        this.bagagesSupplementaires = bagagesSupplementaires;
    }
    // 🔥 LOGIQUE MÉTIER
    public void confirmer() {
        this.statut = CONFIRMEE;
    }
    public void annuler() {
        this.statut = ANNULEE;
    }
    public void ajouterBagage(int poids) {
        if (poids <= 0) {
            System.out.println("Poids invalide !");
            return;
        }
        if (poids > 23) {
            System.out.println("Max 23kg !");
            return;
        }
        bagagesSupplementaires.add(poids);
    }
    public int getTotalBagages() {
        int total = 0;
        if (bagagesSupplementaires != null) {
            for (int p : bagagesSupplementaires) {
                total += p;
            }
        }
        return total;
    }
    public void changerSiege(String siege) {
        if (billet != null) {
            billet.setSiege(siege);
        }
    }
    public void upgraderClasse(String nouvelleClasse) {
        if (billet == null) {
            System.out.println("Pas de billet !");
            return;
        }
        billet.setClasse(nouvelleClasse);
    }
    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", statut='" + statut + '\'' +
                ", date='" + dateReservation + '\'' +
                '}';
    }
}
