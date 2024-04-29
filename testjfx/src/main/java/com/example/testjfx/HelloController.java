package com.example.testjfx;

import com.example.testjfx.model.Recette;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.InputStream;
import java.util.Properties;
import java.io.IOException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
public class HelloController {
    public Label status;
    public TextArea preview;
    public ListView<Recette> recettes;
    public MenuItem help;
    public MenuItem exit;
    public Button add;
    public Button edit;
    public Button delete;
    @FXML
    private Label welcomeText;
    @FXML
    private TextField title;

    @FXML
    private TextArea ingredients;

    @FXML
    private TextArea instructions;

    @FXML
    private TextField preparation;
    @FXML
    public void initialize() {

        Recette recette1 = new Recette("Recette 1", "Ingrédients 1", "Instructions 1", "10 minutes");
        Recette recette2 = new Recette("Recette 2", "Ingrédients 2", "Instructions 2", "15 minutes");
        Recette recette3 = new Recette("Recette 3", "Ingrédients 3", "Instructions 3", "20 minutes");


        ObservableList<Recette> items = FXCollections.observableArrayList(
                recette1,
                recette2,
                recette3
        );

        recettes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Recette>() {
            @Override
            public void changed(ObservableValue<? extends Recette> observable, Recette oldValue, Recette newValue) {
                // Met à jour les champs avec les détails de la recette sélectionnée
                if (newValue != null) {

                    preview.setText(newValue.getPreview());
                    delete.setDisable(false);
                    edit.setDisable(false);
                }
            }
        });


        recettes.setItems(items);


        edit.setDisable(true);
        delete.setDisable(true);
    }


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void displayHelp(ActionEvent actionEvent) {
        Properties properties = new Properties();
        try (InputStream input = getClass().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IOException("Unable to find config.properties file");
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        String version = properties.getProperty("application.version", "Unknown");
        String author = properties.getProperty("application.author", "Unknown");
        String description = properties.getProperty("application.description", "Description not available");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText(null);
        alert.setContentText("Version: " + version + "\nAuthor: " + author + "\nDescription: " + description);
        alert.showAndWait();
    }
    public void exit(ActionEvent actionEvent) {
    }


    public void onAddButtonClick(ActionEvent actionEvent) {
        String newTitle = title.getText();
        String newIngredients = ingredients.getText();
        String newInstructions = instructions.getText();
        String newPreparation = preparation.getText();

        // Vérifie si tous les champs sont remplis
        if (newTitle.isEmpty() || newIngredients.isEmpty() || newInstructions.isEmpty() || newPreparation.isEmpty()) {
            // Affiche un message d'erreur si au moins un champ est vide
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
            return;
        }
        // Crée une nouvelle recette avec les valeurs des champs
        Recette newRecipe = new Recette(newTitle, newIngredients, newInstructions, newPreparation);

        // Ajoute la nouvelle recette à la liste des recettes
        recettes.getItems().add(newRecipe);

        // Affiche un message de succès
        status.setText("Recipe added: " + newRecipe.getTitre());

        // Réinitialise les champs à vide pour permettre l'ajout d'une nouvelle recette
        title.clear();
        ingredients.clear();
        instructions.clear();
        preparation.clear();
    }

    public void onEditButtonClick(ActionEvent actionEvent) {
        // Récupère la recette sélectionnée
        Recette selectedRecipe = recettes.getSelectionModel().getSelectedItem();

        // Vérifie si une recette est sélectionnée
        if (selectedRecipe == null) {
            // Affiche un message d'erreur si aucune recette n'est sélectionnée
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select a recipe to edit.");
            alert.showAndWait();
            return;
        }
        String newTitle = title.getText();
        String newIngredients = ingredients.getText();
        String newInstructions = instructions.getText();
        String newPreparation = preparation.getText();

        // Vérifie si tous les champs sont remplis
        if (newTitle.isEmpty() || newIngredients.isEmpty() || newInstructions.isEmpty() || newPreparation.isEmpty()) {
            // Affiche un message d'erreur si au moins un champ est vide
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
            return;
        }


        // Met à jour les valeurs de la recette sélectionnée
        selectedRecipe.setTitre(newTitle);
        selectedRecipe.setIngredients(newIngredients);
        selectedRecipe.setInstructions(newInstructions);
        selectedRecipe.setPreparation_time(newPreparation);

        // Rafraîchit la vue de la liste des recettes pour refléter les changements
        recettes.refresh();

        // Affiche un message de succès
        status.setText("Recipe edited: " + selectedRecipe.getTitre());

        // Réinitialise les champs à vide pour permettre l'ajout d'une nouvelle recette
        title.clear();
        ingredients.clear();
        instructions.clear();
        preparation.clear();


    }

    public void onDeleteButtonClick(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Delete Recipe");
        alert.setContentText("Êtes-vous bien sûr de vouloir supprimer l'entité?");

        ButtonType buttonTypeYes = new ButtonType("Yes");
        ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);


        alert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == buttonTypeYes) {
                // Supprimer la recette
                Recette selectedRecipe = recettes.getSelectionModel().getSelectedItem();
                if (selectedRecipe != null) {
                    recettes.getItems().remove(selectedRecipe);
                    status.setText("Recipe deleted: " + selectedRecipe);
                }
            }
        });
    }
}


