package com.oandujar.sisu.infraestructure.exception.handler;

import com.oandujar.sisu.infraestructure.exception.ConflictException;
import com.oandujar.sisu.infraestructure.exception.ErrorView;
import com.oandujar.sisu.infraestructure.exception.ForbiddenException;
import com.oandujar.sisu.infraestructure.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Generic handler which translates all retrieved exceptions to 500 error with empty body,
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorView> genericExceptionHandler(Exception ex) {
        return new ResponseEntity<>(
                new ErrorView(ex.getMessage(), String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value())),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ResponseEntity<ErrorView> forbiddenExceptionHandler(ForbiddenException ex) {
        return new ResponseEntity<>(
                new ErrorView(ex.getMessage(), String.valueOf(HttpStatus.FORBIDDEN.value())),
                HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorView> notFoundExceptionHandler(NotFoundException ex) {
        return new ResponseEntity<>(
                new ErrorView(ex.getMessage(), String.valueOf(HttpStatus.NOT_FOUND.value())),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ResponseEntity<ErrorView> conflictFoundExceptionHandler(ConflictException ex) {
        return new ResponseEntity<>(
                new ErrorView(ex.getMessage(), String.valueOf(HttpStatus.CONFLICT.value())),
                HttpStatus.CONFLICT);
    }

}