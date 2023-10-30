package com.oandujar.sisu.infrastructure.exception;

/**
 * Excepción lanzada cuando hay un error al tratar con postgres
 */
public class ORMException extends GlobalException {

    public ORMException(ErrorCode pErrorCode) {
        super(pErrorCode);
    }

    public ORMException(ErrorCode pErrorCode, Object... pArguments) {
        super(pErrorCode, pArguments);
    }

    public ORMException(ErrorCode pErrorCode, Exception newOriginalException) {
        super(pErrorCode, newOriginalException);
    }

    public ORMException(ErrorCode pErrorCode, Exception newOriginalException, Object... pArguments) {
        super(pErrorCode, newOriginalException, pArguments);
    }

}
