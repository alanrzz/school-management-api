package org.school.management.api.error;

import org.school.management.api.exceptions.AlreadyExistsException;
import org.school.management.api.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> AllUnhandledExceptions(Exception ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        return this.buildResponse(apiError);
    }

    @ExceptionHandler(AuthenticationException.class)
    protected ResponseEntity<Object> HandleAuthenticationException(AuthenticationException ex) {
        ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED);
        apiError.setMessage("Error de autorización: " + ex.getMessage() + ".");
        return this.buildResponse(apiError);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<Object> ResourceNotFoundException(ResourceNotFoundException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        return this.buildResponse(apiError);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    protected ResponseEntity<Object> AlreadyExistsException(AlreadyExistsException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        return this.buildResponse(apiError);
    }

    private ResponseEntity<Object> buildResponse(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
