package com.oandujar.sisu.infraestructure.exception.handler;

import com.oandujar.sisu.infraestructure.exception.ConflictException;
import com.oandujar.sisu.infraestructure.exception.ErrorCode;
import com.oandujar.sisu.infraestructure.exception.ForbiddenException;
import com.oandujar.sisu.infraestructure.exception.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class RestResponseEntityExceptionHandlerTest {

    @InjectMocks
    private RestResponseEntityExceptionHandler restResponseEntityExceptionHandler;

    private Exception exception;
    private ForbiddenException forbiddenException;
    private NotFoundException notFoundException;
    private ConflictException conflictException;

    @BeforeEach
    void setUp() {
        exception = new Exception("Error");
        forbiddenException = new ForbiddenException(ErrorCode.ACCESS_DENIED, "Error");
        notFoundException = new NotFoundException(ErrorCode.NOT_FOUND, "Error");
        conflictException = new ConflictException(ErrorCode.CONFLICT, "Error");
    }

    @Test
    void genericExceptionHandler() {
        ResponseEntity response = restResponseEntityExceptionHandler.genericExceptionHandler(exception);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    void forbiddenExceptionHandler() {
        ResponseEntity response = restResponseEntityExceptionHandler.forbiddenExceptionHandler(forbiddenException);
        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
    }

    @Test
    void notFoundExceptionHandler() {
        ResponseEntity response = restResponseEntityExceptionHandler.notFoundExceptionHandler(notFoundException);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void conflictFoundExceptionHandler() {
        ResponseEntity response = restResponseEntityExceptionHandler.conflictFoundExceptionHandler(conflictException);
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }
}