package fr.diginamic.jdbc.dao;

import java.util.List;

import fr.diginamic.entites.Fournisseur;

/**
 * JDBC TP 04
 * 
 * @author Jeremy
 *
 */
public interface FournisseurDao {

	List<Fournisseur> extraire() throws ComptaException;

	void insert(Fournisseur fournisseur) throws ComptaException;

	int update(String ancienNom, String nouveauNom) throws ComptaException;

	boolean delete(Fournisseur fournisseur) throws ComptaException;
}