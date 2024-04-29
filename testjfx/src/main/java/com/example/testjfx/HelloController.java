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
    public void initialize() {

        Recette recette1 = new Recette("Recette 1", "Ingrédients 1", "Instructions 1", "10 minutes");
        Recette recette2 = new Recette("Recette 2", "Ingrédients 2", "Instructions 2", "15 minutes");
        Recette recette3 = new Recette("Recette 3", "Ingrédients 3", "Instructions 3", "20 minutes");


        ObservableList<Recette> items = FXCollections.observableArrayList(
                recette1,
                recette2,
                recette3
        );


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
    }

    public void onEditButtonClick(ActionEvent actionEvent) {
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


