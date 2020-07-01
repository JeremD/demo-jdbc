package fr.diginamic.jdbc.dao;

/**
 * Gestion des exceptions
 * 
 * @author Jeremy
 *
 */
public class ComptaException extends RuntimeException {

	public ComptaException () {
		super();
	}
	
	public ComptaException (String msg) {
		super(msg);
	}
	
	public ComptaException (String msg, Throwable ex) {
		super(msg, ex);
	}
}
