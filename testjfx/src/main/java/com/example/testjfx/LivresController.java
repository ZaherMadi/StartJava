package com.example.testjfx;

import com.example.testjfx.model.Livre;
import com.example.testjfx.model.Recette;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class LivresController {

    public Label status;
    public ImageView imageView;
    public TextArea quatriemecouverture;
    public ListView<Livre> livresListView;
    public TextField titre;
    public TextField isbn;
    public TextField auteur;
    public TextField annee;
    public TextField pages;
    public Button addBtn;
    public Button editBtn;
    public Button deleteBtn;



    private ObservableList<Livre> livres = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        livresListView.setItems(livres);
        livresListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showLivreDetails(newValue));
        //LivresExemples();
        getLivresFromDatabase(); // Appel de la méthode pour charger les livres depuis la base de données
    }

    private void getLivresFromDatabase() {
        livres.addAll(DatabaseManager.getLivresFromDatabase());
    }

    private void showLivreDetails(Livre livre) {
        if (livre != null) {
            titre.setText(livre.getTitre());
            isbn.setText(livre.getISBN());
            auteur.setText(livre.getAuteur());
            annee.setText(String.valueOf(livre.getAnneePublication()));
            pages.setText(String.valueOf(livre.getNombrePages()));
            quatriemecouverture.setText(livre.getQuatriemeDeCouverture());
//            Image imageCouverture = livre.getImageCouverture();
//            imageView.setImage(imageCouverture);
        } else {
            clears();
        }
    }

    private void clears() {
        titre.setText("");
        isbn.setText("");
        auteur.setText("");
        annee.setText("");
        pages.setText("");
        quatriemecouverture.setText("");;
        imageView.setImage(null);
    }



    @FXML
    protected void ajouterLivre() {
        Livre selectedLivre = livresListView.getSelectionModel().getSelectedItem();
        if (selectedLivre != null) {
            // Demander confirmation à l'utilisateur avant de supprimer le livre
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText("Voulez-vous vraiment ajouter ce livre ?");
            alert.setContentText("Cette action est irréversible.");

            // Attendre la réponse de l'utilisateur
            ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);

            if (result == ButtonType.OK) {
                // Supprimer le livre de la liste et de la base de données
                livres.remove(selectedLivre);
                String ConfirmationSupp = selectedLivre.getTitre();
                Alert alertConfirmation = new Alert(Alert.AlertType.ERROR);
                alertConfirmation.setTitle("Effectué");
                alertConfirmation.setHeaderText(null);
                alertConfirmation.setContentText(ConfirmationSupp + " à bien été supprimé.");
                alertConfirmation.showAndWait();
            }
        }
    }

    @FXML
    protected void mettreAJourLivre() {
        // Ajoutez le code pour modifier les détails d'un livre sélectionné dans la liste et dans la base de données
        Livre selectedLivre = livresListView.getSelectionModel().getSelectedItem();
        if (selectedLivre != null) {
            // Demander confirmation à l'utilisateur avant de supprimer le livre
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText("Voulez-vous vraiment supprimer ce livre ?");
            alert.setContentText("Cette action est irréversible.");

            // Attendre la réponse de l'utilisateur
            ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);

            if (result == ButtonType.OK) {
                // Supprimer le livre de la liste et de la base de données
                livres.remove(selectedLivre);
//                livres.add(selectedLivre);
                String ConfirmationSupp = selectedLivre.getTitre();
                Alert alertConfirmation = new Alert(Alert.AlertType.ERROR);
                alertConfirmation.setTitle("Effectué");
                alertConfirmation.setHeaderText(null);
                alertConfirmation.setContentText(ConfirmationSupp + " à bien été supprimé.");
                alertConfirmation.showAndWait();
            }
        }
    }

    @FXML
    protected void supprimerLivre() {
        // Ajoutez le code pour supprimer un livre sélectionné de la liste et de la base de données
        Livre selectedLivre = livresListView.getSelectionModel().getSelectedItem();
        if (selectedLivre != null) {
            // Demander confirmation à l'utilisateur avant de supprimer le livre
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText("Voulez-vous vraiment supprimer ce livre ?");
            alert.setContentText("Cette action est irréversible.");

            // Attendre la réponse de l'utilisateur
            ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);

            if (result == ButtonType.OK) {
                // Supprimer le livre de la liste et de la base de données
                livres.remove(selectedLivre);
                String ConfirmationSupp = selectedLivre.getTitre();
                Alert alertConfirmation = new Alert(Alert.AlertType.ERROR);
                alertConfirmation.setTitle("Effectué");
                alertConfirmation.setHeaderText(null);
                alertConfirmation.setContentText(ConfirmationSupp + " à bien été supprimé.");
                alertConfirmation.showAndWait();
            }
        } else {
            // Afficher un message d'erreur si aucun livre n'est sélectionné
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de suppression");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez sélectionner un livre à supprimer.");
            alert.showAndWait();
        }
    }
}
