package com.example.ProjectPlayers.core.utilities.exceptions;

public class DataIntegrityViolationException extends org.springframework.dao.DataIntegrityViolationException{

	

	public DataIntegrityViolationException(String message) {
		super(message);
	}

}
