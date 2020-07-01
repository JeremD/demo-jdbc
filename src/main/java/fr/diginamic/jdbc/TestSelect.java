package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.entites.Fournisseur;

/**
 * JDBC TP 03 - Exercice 4
 * 
 * @author Jeremy
 *
 */
public class TestSelect {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		// Lecture du properties
		ResourceBundle database = ResourceBundle.getBundle("database");

		Class.forName(database.getString("database.driver"));
		String url = database.getString("database.url");
		String user = database.getString("database.user");
		String password = database.getString("database.pass");

		// Connexion à la BDD
		try (Connection connexion = DriverManager.getConnection(url, user, password)) {

			connexion.setAutoCommit(false);

			// Execution des requetes
			try (Statement statement = connexion.createStatement();) {

				// Sélection de la liste les fournisseur
				ResultSet resultSet = statement.executeQuery("select * from FOURNISSEUR");

				// ArrayList des fournisseurs
				List<Fournisseur> arrayFournisseur = new ArrayList<>();
				
				while (resultSet.next()) {
					int id = Integer.parseInt(resultSet.getString("ID"));
					String nom = resultSet.getString("NOM");
					
					Fournisseur nomFournisseur = new Fournisseur(id, nom);
					arrayFournisseur.add(nomFournisseur);
				}
				
				// Affichage ArrayList
				for (int i = 0; i < arrayFournisseur.size(); i++) {
					System.out.println(arrayFournisseur.get(i));
				}

				connexion.commit();

			} catch (SQLException e) {
				connexion.rollback();
				System.err.println(e.getMessage());
			}
		}
	}

}
