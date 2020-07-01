package fr.diginamic.jdbc;

import fr.diginamic.jdbc.dao.FournisseurDao;
import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;

/**
 * JDBC TP 04
 * 
 * @author Jeremy
 *
 */
public class TestUpdate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String ancienNom = "FDM SA";
		String nouveauNom = "FDM SA & CO";
		FournisseurDao monFournisseur = new FournisseurDaoJdbc();

		monFournisseur.update(ancienNom, nouveauNom);
		System.out.println(ancienNom + " remplacé par " + nouveauNom);
	}

}
