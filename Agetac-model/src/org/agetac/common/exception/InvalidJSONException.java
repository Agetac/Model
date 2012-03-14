package org.agetac.common.exception;

public class InvalidJSONException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5858439127630796645L;

	public InvalidJSONException(String m){
		System.out.println("Le JSON transmit semble invalide.");
		System.out.println(m);
	}
}
