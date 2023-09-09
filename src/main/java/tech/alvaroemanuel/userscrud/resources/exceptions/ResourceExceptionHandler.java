package tech.alvaroemanuel.userscrud.resources.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import tech.alvaroemanuel.userscrud.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	 @ExceptionHandler(ResourceNotFoundException.class)
	 public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException error, WebRequest request) {
         StandardError errorMessage = new StandardError(
        		 new Date(), 
        		 error.getMessage(), 
        		 HttpStatus.NOT_FOUND.value(),
        		 error.getMessage(), 
        		 request.getDescription(false)
         );
         
         return new ResponseEntity<StandardError>(errorMessage, HttpStatus.NOT_FOUND);
	 }   

	 @ExceptionHandler(Exception.class)
	 public ResponseEntity<StandardError> globleExcpetionHandler(Exception error, WebRequest request) {
		 StandardError errorMessage = new StandardError(
        		 new Date(), 
        		 error.getMessage(),
        		 HttpStatus.INTERNAL_SERVER_ERROR.value(),
        		 error.getMessage(), 
        		 request.getDescription(false)
         );
         
         return new ResponseEntity<StandardError>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	 }	 
}
