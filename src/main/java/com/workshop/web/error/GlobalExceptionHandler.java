package com.workshop.web.error;


import org.hibernate.exception.JDBCConnectionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.net.ConnectException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {



    @ExceptionHandler({CountryNotFoundException.class, EntityNotFoundException.class})
    public ResponseEntity<ErrorResponse> notFoundHndler(Exception ex, WebRequest request) {
        ErrorResponse errors = new ErrorResponse();
        errors.setMessage(ex.getMessage());
        errors.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({JDBCConnectionException.class, ConnectException.class})
    public ResponseEntity<ErrorResponse> serverDown(Exception ex, WebRequest request) {
        ErrorResponse errors = new ErrorResponse();
        errors.setMessage("INTERNAL_ERROR");
        errors.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
