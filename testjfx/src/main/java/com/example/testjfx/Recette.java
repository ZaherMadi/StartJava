package com.example.testjfx;

public class Recette {
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

