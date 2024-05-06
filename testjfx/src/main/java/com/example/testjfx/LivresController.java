package com.example.testjfx;

import com.example.testjfx.model.Livre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class LivresController {

    public Label status;
    public ImageView imageView;
    public Label quatriemecouverture;
    public ListView<Livre> livresListView;
    public Label titre;
    public Label isbn;
    public Label auteur;
    public Label annee;
    public Label pages;
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

    private void LivresExemples() {
        livres.addAll(
                new Livre("Titre du livre 1", "ISBN 1", "Auteur 1", 2000, 300, "Description du livre 1"),
                new Livre("Titre du livre 2", "ISBN 2", "Auteur 2", 2005, 250, "Description du livre 2"),
                new Livre("Titre du livre 3", "ISBN 3", "Auteur 3", 2010, 400, "Description du livre 3")
        );
    }

    @FXML
    protected void ajouterLivre() {
        // Ajoutez le code pour ajouter un nouveau livre à la liste et à la base de données
    }

    @FXML
    protected void mettreAJourLivre() {
        // Ajoutez le code pour modifier les détails d'un livre sélectionné dans la liste et dans la base de données
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
                String ConfirmationSupp = DatabaseManager.supprimerLivre(selectedLivre);
                Alert alertConfirmation = new Alert(Alert.AlertType.ERROR);
                alertConfirmation.setTitle("Effectué");
                alertConfirmation.setHeaderText(null);
                alertConfirmation.setContentText(ConfirmationSupp);
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
