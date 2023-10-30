package com.oandujar.sisu.infrastructure.exception;

/**
 * Excepción lanzada cuando no se tienen permisos de acceso
 */
public class ForbiddenException extends GlobalException {

    public ForbiddenException(ErrorCode pErrorCode) {
        super(pErrorCode);
    }

    public ForbiddenException(ErrorCode pErrorCode, Object... pArguments) {
        super(pErrorCode, pArguments);
    }

    public ForbiddenException(ErrorCode pErrorCode, Exception newOriginalException) {
        super(pErrorCode, newOriginalException);
    }

    public ForbiddenException(ErrorCode pErrorCode, Exception newOriginalException, Object... pArguments) {
        super(pErrorCode, newOriginalException, pArguments);
    }

}
