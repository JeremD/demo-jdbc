package fr.diginamic.jdbc;

import fr.diginamic.entites.Fournisseur;
import fr.diginamic.jdbc.dao.FournisseurDao;
import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;

/**
 * JDBC TP 04
 * 
 * @author Jeremy
 *
 */
public class TestDelete {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Fournisseur monFournisseur = new Fournisseur(5, "Chez babel");
		FournisseurDao inserFournisseur = new FournisseurDaoJdbc();

		inserFournisseur.delete(monFournisseur);
		System.out.println("Suppression du fournisseur " + monFournisseur.getNom());
	}

}
