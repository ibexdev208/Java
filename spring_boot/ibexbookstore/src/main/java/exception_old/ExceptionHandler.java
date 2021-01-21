package exception_old;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice //handles exceptions globally
public class ExceptionHandler  extends ResponseEntityExceptionHandler {

	//handles specific exception
	//@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {
		
		ErrorMessage em = new ErrorMessage(new Date(), exception.getMessage(), request.getDescription(false));
		
		return new ResponseEntity(em, HttpStatus.NOT_FOUND);
	}
	
	
	//@ExceptionHandler(APIExceptoin.class)
	public ResponseEntity<ErrorMessage> handleApiExceptoin(APIExceptoin exception, WebRequest request) {
		
		ErrorMessage em = new ErrorMessage(new Date(), exception.getMessage(), request.getDescription(false));
		
		return new ResponseEntity(em, HttpStatus.NOT_FOUND);
	}
	
	//handling all other exceptions
	//@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handlGlobalException(Exception exception, WebRequest request) {
		
		ErrorMessage em = new ErrorMessage(new Date(), exception.getMessage(), request.getDescription(false));
		
		return new ResponseEntity(em, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
//	@ExceptionHandler(ResourceNotFoundException.class)
//	public void springHandleNotFound(HttpServletResponse response) throws IOException {
//		response.sendError(HttpStatus.NOT_FOUND.value());
//	}
	
	
//	public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
//		ErrorMessage message = new ErrorMessage(
//				HttpStatus.NOT_FOUND.value(),
//				new Date(),
//				ex.getMessage(),
//				request.getDescription(false));
//
//		return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
//	}

//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex, WebRequest request) {
//		ErrorMessage message = new ErrorMessage(
//				HttpStatus.INTERNAL_SERVER_ERROR.value(),
//				new Date(),
//				ex.getMessage(),
//				request.getDescription(false));
//
//		return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
}
