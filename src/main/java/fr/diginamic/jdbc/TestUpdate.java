package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * JDBC TP 03 - Exercice 2
 * 
 * @author Jeremy
 *
 */
public class TestUpdate {

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

				// Modification
				statement.executeUpdate(
						"update FOURNISSEUR set NOM='La Maison des Peintures' WHERE NOM='La Maison de la Peinture'");

				// Selection
				ResultSet resultSet = statement.executeQuery("select * from FOURNISSEUR");

				while (resultSet.next()) {
					String nomFournisseur = resultSet.getString("NOM");
					System.out.println(nomFournisseur);
				}
				connexion.commit();

			} catch (SQLException e) {
				connexion.rollback();
				System.err.println(e.getMessage());
			}
		}
	}

}
