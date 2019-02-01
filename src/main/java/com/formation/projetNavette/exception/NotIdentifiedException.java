package com.formation.projetNavette.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotIdentifiedException extends RuntimeException {

	private static final long serialVersionUID = -1749672979746392283L;
	
	public NotIdentifiedException() {
	}

	public NotIdentifiedException(String msg) {
		super(msg);
	}

}