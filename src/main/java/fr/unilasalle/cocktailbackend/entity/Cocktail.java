package fr.unilasalle.cocktailbackend.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Cocktail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String description;
    private boolean alcoolise;
    private String imageUrl;

    @OneToMany(mappedBy = "cocktail", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingredient> ingredients;

    public Cocktail() {}

    public Cocktail(Long id, String nom, String description, boolean alcoolise, String imageUrl, List<Ingredient> ingredients) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.alcoolise = alcoolise;
        this.imageUrl = imageUrl;
        this.ingredients = ingredients;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public boolean isAlcoolise() {
        return alcoolise;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAlcoolise(boolean alcoolise) {
        this.alcoolise = alcoolise;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
