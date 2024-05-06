package com.example.testjfx;

import com.example.testjfx.model.Livre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.DriverManager;
import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:recettes.db";
    private static ObservableList<Livre> livres = FXCollections.observableArrayList(); // Déclaration de la liste livres

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static ObservableList<Livre> getLivres() {
        return livres;
    }

    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            // Étape 2 : Exécuter une requête SQL pour récupérer les données
            String query = "SELECT * FROM Livres";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                // Étape 3 : Traiter les résultats de la requête
                while (resultSet.next()) {
                    String titre = resultSet.getString("titre");
                    String isbn = resultSet.getString("isbn");
                    String auteur = resultSet.getString("auteur");
                    int annee = resultSet.getInt("annee_publication");
                    int pages = resultSet.getInt("nombre_pages");
                    String quatriemeDeCouverture = resultSet.getString("quatrieme_de_couverture");

                    System.out.println("Titre: " + titre);
                    System.out.println("ISBN: " + isbn);
                    System.out.println("Auteur: " + auteur);
                    System.out.println("Année de publication: " + annee);
                    System.out.println("Nombre de pages: " + pages);
                    System.out.println("Quatrième de couverture: " + quatriemeDeCouverture);
                    System.out.println("--------------------");


                    // Créer un objet Livre et le stocker dans une liste ou une autre structure de données
                    String imageCouverture = "";
                    Livre livre = new Livre(titre, isbn, auteur, annee, pages, quatriemeDeCouverture);
                    // Ajouter livre à votre liste observable
                    livres.add(livre);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<Livre> getLivresFromDatabase() {
        ObservableList<Livre> livresFromDB = FXCollections.observableArrayList();
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM Livres";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    String titre = resultSet.getString("titre");
                    String isbn = resultSet.getString("isbn");
                    String auteur = resultSet.getString("auteur");
                    int annee = resultSet.getInt("annee_publication");
                    int pages = resultSet.getInt("nombre_pages");
                    String quatriemeDeCouverture = resultSet.getString("quatrieme_de_couverture");

                    // Créer un objet Livre et le stocker dans une liste
                    String imageCouverture = resultSet.getString("nombre_pages");
                    Livre livre = new Livre(titre, isbn, auteur, annee, pages, quatriemeDeCouverture);
                    livresFromDB.add(livre);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livresFromDB;
    }

//    public static String supprimerLivre(Livre selectedLivre) {
//        return("Le livre " + selectedLivre + " à bien été supprimé");
//    }

    public static String supprimerLivre(Livre livre) {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM Livres WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, livre.getId()); // Supposant que votre livre a un identifiant (id)
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void ajouterLivre(Livre livre) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO Livres (titre, isbn, auteur, annee_publication, nombre_pages, quatrieme_de_couverture) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, livre.getTitre());
                preparedStatement.setString(2, livre.getISBN());
                preparedStatement.setString(3, livre.getAuteur());
                preparedStatement.setInt(4, livre.getAnneePublication());
                preparedStatement.setInt(5, livre.getNombrePages());
                preparedStatement.setString(6, livre.getQuatriemeDeCouverture());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    public static void mettreAJourLivre(Livre livre) {
        try (Connection connection = getConnection()) {
            String query = "UPDATE Livres SET titre = ?, isbn = ?, auteur = ?, annee_publication = ?, " +
                    "nombre_pages = ?, quatrieme_de_couverture = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, livre.getTitre());
                preparedStatement.setString(2, livre.getISBN());
                preparedStatement.setString(3, livre.getAuteur());
                preparedStatement.setInt(4, livre.getAnneePublication());
                preparedStatement.setInt(5, livre.getNombrePages());
                preparedStatement.setString(6, livre.getQuatriemeDeCouverture());
                preparedStatement.setInt(7, livre.getId()); // Supposant que votre livre a un identifiant (id)
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
