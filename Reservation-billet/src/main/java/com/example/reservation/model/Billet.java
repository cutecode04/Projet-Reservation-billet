package com.example.reservation.model;

import jakarta.persistence.*;

@Entity
public class Billet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(name = "passager_id")
    private Passager passager;
    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;
    @ManyToOne
    @JoinColumn(name = "vol_id")
    private Vol vol;
    private Long numero;

    private Double prix;
    private String siege;
    private String classe;
    private String statut;

    public Billet() {}

    public Long getNumero() { return numero; }

    public Double getPrix() { return prix; }
    public void setPrix(Double prix) { this.prix = prix; }

    public String getSiege() { return siege; }
    public void setSiege(String siege) { this.siege = siege; }

    public String getClasse() { return classe; }
    public void setClasse(String classe) { this.classe = classe; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
}
