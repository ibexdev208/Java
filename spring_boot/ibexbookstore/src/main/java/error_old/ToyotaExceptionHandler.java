package error_old;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ToyotaExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ToyotaException.class)
	public ResponseEntity<Object> handleToyota(ToyotaException exception) {
		
		Error error = new Error();
		error.setError(exception.getErrorMessage());
		
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
