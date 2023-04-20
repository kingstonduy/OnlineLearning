package com.example.rest.webservices.restfulwebservices.restfulwebservices.exception;

import java.time.LocalDateTime;

import com.example.rest.webservices.restfulwebservices.restfulwebservices.user.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
        // ErrorDetails la 1 class dc minh tao extends exception de handle exception message
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    // modify the type (404, 202, 200, ...) of the specifi exception UserNotFoundException
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
        // ErrorDetails la 1 class dc minh tao extends exception de handle exception message
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        // can modify the type of exception by the HttpStatus
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        // ErrorDetails la 1 class dc minh tao extends exception de handle exception message
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                                            "Total Errors: "  +ex.getErrorCount() +
                                                    " First error: "  +ex.getFieldError().getDefaultMessage(),
                                                    request.getDescription(false));

        // can modify the type of exception by the HttpStatus
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

}