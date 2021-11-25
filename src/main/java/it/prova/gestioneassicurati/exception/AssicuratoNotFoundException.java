package it.prova.gestioneassicurati.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AssicuratoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AssicuratoNotFoundException(String message) {
		super(message);
	}

}
