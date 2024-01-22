package com.oandujar.domain.exception;

import java.util.Map;

public class InfraException extends DomainException {

    public InfraException(InfraErrorType errorType, String... args) {
        super(errorType, args);
    }
    public InfraException(InfraErrorType errorType, Map<String, Object> metadata, String... args) {
        super(errorType, metadata, args);
    }

    @Override
    public InfraErrorType getErrorType() {
        return (InfraErrorType) super.getErrorType();
    }


}
