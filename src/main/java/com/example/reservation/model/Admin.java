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
       this.nom=nom;
       this.email=email;
       this.motDePasse=motDePasse;
    }

    //VALIDATIONS

    public void setNom(String nom) {
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Nom invalide !");
        }
        this.nom = nom;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Email invalide !");
        }
        this.email = email;
    }

    public void setMotDePasse(String motDePasse) {
        if (motDePasse == null || motDePasse.length() < 4) {
            throw new IllegalArgumentException("Mot de passe trop court !");
        }
        this.motDePasse = motDePasse;
    }

    // GETTERS
    public Long getId() { return id; }
    public String getNom() { return nom; }
    public String getEmail() { return email; }
    public String getMotDePasse() { return motDePasse; }

    // Methode
    public boolean verifierConnexion(String email, String motDePasse) {
        return this.email.equals(email) && this.motDePasse.equals(motDePasse);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}