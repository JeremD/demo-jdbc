package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.entites.Fournisseur;

/**
 * JDBC TP 04
 * 
 * @author Jeremy
 *
 */
public class FournisseurDaoJdbc implements FournisseurDao {

	private ResourceBundle database = ResourceBundle.getBundle("database");

	private String url = database.getString("database.url");
	private String user = database.getString("database.user");
	private String password = database.getString("database.pass");

	private Connection connexion;
	private Statement statement;

	@Override
	public List<Fournisseur> extraire() {
		try {
			Class.forName(database.getString("database.driver"));
		} catch (ClassNotFoundException e) {
			throw new ComptaException("Erreur d'accès à la base de données", e);
		}
		
		try {
			connexion = DriverManager.getConnection(url, user, password);
			statement = connexion.createStatement();

			statement.executeQuery("select * from FOURNISSEUR");
			return null;
		} catch (SQLException e) {
			throw new ComptaException("Erreur de requête SQL", e);
		}
	}

	@Override
	public void insert(Fournisseur fournisseur) {
		
		try {
			Class.forName(database.getString("database.driver"));
		} catch (ClassNotFoundException e) {
			throw new ComptaException("Erreur d'accès à la base de données", e);
		}
		
		try {
			connexion = DriverManager.getConnection(url, user, password);
			statement = connexion.createStatement();

			statement.executeUpdate("insert into FOURNISSEUR(id, nom) values(" + fournisseur.getId() + ", '" +  fournisseur.getNom() + "')");
		} catch (SQLException e) {
			throw new ComptaException("Erreur de requête SQL", e);
		}
	}

	/**
	 * update
	 */
	@Override
	public int update(String ancienNom, String nouveauNom) throws ComptaException {

		try {
			Class.forName(database.getString("database.driver"));
		} catch (ClassNotFoundException e) {
			throw new ComptaException("Erreur d'accès à la base de données", e);
		}

		try {
			connexion = DriverManager.getConnection(url, user, password);
			statement = connexion.createStatement();
			
			return statement.executeUpdate("update FOURNISSEUR set NOM='" + nouveauNom + "' WHERE NOM='" + ancienNom + "'");
		
		} catch (SQLException e) {
			throw new ComptaException("Erreur de requête SQL", e);
		}

	}

	@Override
	public boolean delete(Fournisseur fournisseur) {
		try {
			Class.forName(database.getString("database.driver"));
		} catch (ClassNotFoundException e) {
			throw new ComptaException("Erreur d'accès à la base de données", e);
		}

		try {
			connexion = DriverManager.getConnection(url, user, password);
			statement = connexion.createStatement();
			
			statement.executeUpdate("delete from FOURNISSEUR where NOM='" + fournisseur.getNom() + "'");
			return true;
			
		} catch (SQLException e) {
			throw new ComptaException("Erreur de requête SQL", e);
		}
		
	}

}
