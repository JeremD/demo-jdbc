package fr.diginamic.entites;

/**
 * Représente les fournisseurs
 * 
 * @author Jeremy
 *
 */
public class Fournisseur {

	/** id */
	private int id;

	/** nom */
	private String nom;

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param nom
	 */
	public Fournisseur(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter
	 * 
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * 
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * toString()
	 */
	@Override
	public String toString() {
		return "Fournisseur n° " + id + ", Nom : " + nom;
	}

}
