package com.example.reservation.model;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class CompagnieAerienne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String pays;
    // Relation : 1 compagnie → plusieurs avions
    @OneToMany(mappedBy = "compagnie", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Avion> avions;
    // Constructeur vide obligatoire
    public CompagnieAerienne() {
    }
    // Constructeur
    public CompagnieAerienne(String code, String pays) {
        this.code = code;
        this.pays = pays;
    }
    // Getters et Setters
    public Long getId() {
        return id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        if (code == null || code.isEmpty()) {
            System.out.println("Code invalide !");
        } else {
            this.code = code;
        }
    }
    public String getPays() {
        return pays;
    }
    public void setPays(String pays) {
        if (pays == null || pays.isEmpty()) {
            System.out.println("Pays invalide !");
        } else {
            this.pays = pays;
        }
    }
    public List<Avion> getAvions() {
        return avions;
    }
    public void setAvions(List<Avion> avions) {
        this.avions = avions;
    }
    @Override
    public String toString() {
        return "CompagnieAerienne{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", pays='" + pays + '\'' +
                '}';
    }
}
