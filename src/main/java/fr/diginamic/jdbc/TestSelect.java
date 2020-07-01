package fr.diginamic.jdbc;

import java.util.List;

import fr.diginamic.entites.Fournisseur;
import fr.diginamic.jdbc.dao.FournisseurDao;
import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;

/**
 * JDBC TP 04
 * 
 * @author Jeremy
 *
 */
public class TestSelect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FournisseurDao inserFournisseur = new FournisseurDaoJdbc();
		List<Fournisseur> listeFournisseur = inserFournisseur.extraire();

		listeFournisseur.forEach(System.out::println);
	}

}
