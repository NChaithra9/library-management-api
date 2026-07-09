package com.library.library_management_api.exception;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> handleBookNotFoundException(BookNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);         
}

    @ExceptionHandler(BookUnavailableException.class)
    public ResponseEntity<String> handleBookUnavailableException(BookUnavailableException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(org.springframework.security.core.AuthenticationException.class)
public ResponseEntity<?> handleAuthError(org.springframework.security.core.AuthenticationException ex) {
    return ResponseEntity.status(401).body("Invalid username or password");
}
@ExceptionHandler(DuplicateResourceException.class)
public ResponseEntity<String> handleDuplicateResourceException(DuplicateResourceException ex) {
    return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
}

}
