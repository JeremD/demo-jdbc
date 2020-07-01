package fr.diginamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * Demo JDBC
 * 
 * @author Jeremy
 *
 */
public class TestConnexionJdbc {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		ResourceBundle database = ResourceBundle.getBundle("database");

		Class.forName(database.getString("database.driver"));
		String url = database.getString("database.url");
		String user = database.getString("database.user");
		String password = database.getString("database.pass");

		try (Connection connexion = DriverManager.getConnection(url, user, password)) {

			try (Statement statement = connexion.createStatement();
					ResultSet resultSet = statement.executeQuery("select * from fournisseur");) {
				while (resultSet.next()) {
					String getNom = resultSet.getString("nom");
					System.out.println(getNom);
				}
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

}
