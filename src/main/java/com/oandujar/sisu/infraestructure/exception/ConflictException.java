package com.oandujar.sisu.infraestructure.exception;

/**
 * Excepción lanzada cuando hay un error al tratar con
 */
public class ConflictException extends GlobalException {

    public ConflictException(ErrorCode pErrorCode) {
        super(pErrorCode);
    }

    public ConflictException(ErrorCode pErrorCode, Object... pArguments) {
        super(pErrorCode, pArguments);
    }

    public ConflictException(ErrorCode pErrorCode, Exception newOriginalException) {
        super(pErrorCode, newOriginalException);
    }

    public ConflictException(ErrorCode pErrorCode, Exception newOriginalException, Object... pArguments) {
        super(pErrorCode, newOriginalException, pArguments);
    }

}
