package com.oandujar.sisu.infrastructure.exception;

public class NotFoundException extends GlobalException {
    public NotFoundException(ErrorCode pErrorCode) {
        super(pErrorCode);
    }

    public NotFoundException(ErrorCode pErrorCode, Object... pArguments) {
        super(pErrorCode, pArguments);
    }

    public NotFoundException(ErrorCode pErrorCode, Exception newOriginalException) {
        super(pErrorCode, newOriginalException);
    }

    public NotFoundException(ErrorCode pErrorCode, Exception newOriginalException, Object... pArguments) {
        super(pErrorCode, newOriginalException, pArguments);
    }
}
