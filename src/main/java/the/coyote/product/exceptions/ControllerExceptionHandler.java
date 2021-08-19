package the.coyote.product.exceptions;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<StandardError> notFoundException(NotFoundException e, ServletRequest request) {
		StandardError error = new StandardError(
				System.currentTimeMillis(),
				HttpStatus.NOT_FOUND.value(),
				e.getMessage()
		);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(IntegratyViolationException.class)
	public ResponseEntity<StandardError> integratyViolationException(IntegratyViolationException e, ServletRequest request) {
		StandardError error = new StandardError(
				System.currentTimeMillis(),
				HttpStatus.BAD_REQUEST.value(),
				e.getMessage()
		);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(error);
	}
	
	
}
