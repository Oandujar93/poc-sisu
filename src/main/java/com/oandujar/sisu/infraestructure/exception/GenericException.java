package com.oandujar.sisu.infraestructure.exception;

public interface GenericException {

    /**
     * Retorna el código de error.
     * @return Código que identifica el error producido
     */
    ErrorCode getErrorCode();
}
