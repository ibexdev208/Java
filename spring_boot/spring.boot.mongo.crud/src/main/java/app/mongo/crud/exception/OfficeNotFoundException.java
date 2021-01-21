package app.mongo.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OfficeNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public OfficeNotFoundException(String response) {
		super(response);
	}
}
