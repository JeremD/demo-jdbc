package fr.diginamic.jdbc.dao;

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
 * JDBC TP 04
 * 
 * @author Jeremy
 *
 */
public class FournisseurDaoJdbc implements FournisseurDao {

	/** database */
	private ResourceBundle database = ResourceBundle.getBundle("database");

	/** url */
	private String url = database.getString("database.url");
	
	/** user */
	private String user = database.getString("database.user");
	
	/** password */
	private String password = database.getString("database.pass");

	/** connexion */
	private Connection connexion;
	
	/** statement */
	private Statement statement;

	/**
	 * Extraire la liste des fournisseurs
	 * 
	 * @return liste des fournisseurs
	 */
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

			List<Fournisseur> list = new ArrayList<>();
			ResultSet resultSet = statement.executeQuery("select * from FOURNISSEUR");

			while (resultSet.next()) {
				int id = resultSet.getInt("ID");
				String nom = resultSet.getString("NOM");

				Fournisseur Fournisseur = new Fournisseur(id, nom);
				list.add(Fournisseur);
			}

			return list;

		} catch (SQLException e) {
			throw new ComptaException("Erreur de requête SQL", e);
		}
	}

	/**
	 * Ajouter un fournisseur
	 * 
	 * @param fournisseur
	 */
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

			statement.executeUpdate("insert into FOURNISSEUR(id, nom) values(" + fournisseur.getId() + ", '" + fournisseur.getNom() + "')");
		} catch (SQLException e) {
			throw new ComptaException("Erreur de requête SQL", e);
		}
	}

	/**
	 * Mettre à jour un fournisseur
	 * 
	 * @param fournisseur
	 * @return int
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

	/**
	 * Supprimer un fournisseur
	 * 
	 * @param fournisseur
	 * @return bool
	 */
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
