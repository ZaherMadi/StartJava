package com.example.testjfx.model;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;

@Entity
public class Recette {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titre;
    private String ingredients;
    private String instructions;
    private String preparation_time;
public Recette(String titre, String ingredients, String instructions, String preparation_time) {
        this.titre = titre;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.preparation_time = preparation_time;
    }

    public Recette() {
        this.titre = "Recette";
        this.ingredients = "Un grédient";
        this.instructions =  "Instructions";
        this.preparation_time = "30 min";
    }


    // Getters/setters
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getPreparation_time() {
        return preparation_time;
    }

    public void setPreparation_time(String preparation_time) {
        this.preparation_time = preparation_time;
    }

    public String getPreview() {
        return this.getTitre() + "\n\n" +
                "Durée de préparation :\n" + this.getPreparation_time() + "\n" +
                "\nIngrédients :\n" + this.getIngredients() +
                "\n\nInstructions :\n" + this.getInstructions();
    }

    @Override
    public String toString() {
        // Utilisé par ListView pour afficher le texte
        return getTitre();
    }
}

