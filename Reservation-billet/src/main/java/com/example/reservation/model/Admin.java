package com.example.reservation.model;

import jakarta.persistence.*;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String email;
    private String motDePasse;

    public Admin() {}

    public Admin(String nom, String email, String motDePasse) {
        this.nom = (nom != null && !nom.isEmpty()) ? nom : "Admin_Anonyme";
        this.email = (email != null && email.contains("@")) ? email : "admin@gmail.com";
        this.motDePasse = (motDePasse != null && motDePasse.length() >= 4) ? motDePasse : "1234";
    }

    public void seConnecter(String email, String motDePasse) {
        if (this.email.equals(email) && this.motDePasse.equals(motDePasse)) {
            System.out.println("Connexion réussie : " + nom);
        } else {
            System.out.println("Erreur login");
        }
    }

    public Long getId() { return id; }
    public String getNom() { return nom; }
    public String getEmail() { return email; }
    public String getMotDePasse() { return motDePasse; }

    public void setNom(String nom) { this.nom = nom; }
    public void setEmail(String email) { this.email = email; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }
}