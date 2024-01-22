package com.oandujar.domain.exception;

import java.util.Map;

public class BusinessException extends DomainException {

    public BusinessException(BusinessErrorType errorType, String... args) {
        super(errorType, args);
    }

    public BusinessException(BusinessErrorType errorType, Map<String, Object> metadata, String... args) {
        super(errorType, metadata, args);
    }

    public Integer getErrorCode() {
        return getErrorType().getCode();
    }

    @Override
    public BusinessErrorType getErrorType() {
        return (BusinessErrorType) super.getErrorType();
    }
}
