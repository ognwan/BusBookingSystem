/**
 * 
 */
package com.ognwan.exceptions;

/**
 * @author gerry
 * @version 1.0
 * 
 */
public class AlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public AlreadyExistsException(String message) {
		super(message);
	}
}
