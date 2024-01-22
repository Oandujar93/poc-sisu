package com.oandujar.domain.exception;

import lombok.Data;

import java.util.Map;


@Data
public class DomainException extends RuntimeException {
    private ErrorType errorType;
    private String[] args;
    private Map<String, Object> metadata;

    DomainException(ErrorType errorType, String... args) {
        this.args = args;
        this.errorType = errorType;
    }

    DomainException(ErrorType errorType, Map<String, Object> metadata, String... args) {
        this.args = args;
        this.errorType = errorType;
        this.metadata = metadata;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public String getErrorName() {
        return errorType.getName();
    }

    public String getDescription() {
        return String.format(errorType.getDescription(), args);
    }
}
