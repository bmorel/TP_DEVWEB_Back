package fr.unilasalle.cocktailbackend.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String quantite;
    private String unite;

    @ManyToOne
    @JoinColumn(name = "cocktail_id")
    @JsonIgnore // Ajout de cette annotation pour éviter la sérialisation infinie
    private Cocktail cocktail;

    public Ingredient() {}

    public Ingredient(Long id, String nom, String quantite, String unite, Cocktail cocktail) {
        this.id = id;
        this.nom = nom;
        this.quantite = quantite;
        this.unite = unite;
        this.cocktail = cocktail;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getQuantite() {
        return quantite;
    }

    public String getUnite() {
        return unite;
    }

    public Cocktail getCocktail() {
        return cocktail;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public void setCocktail(Cocktail cocktail) {
        this.cocktail = cocktail;
    }
}
