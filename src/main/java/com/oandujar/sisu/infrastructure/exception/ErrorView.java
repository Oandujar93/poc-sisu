package com.oandujar.sisu.infrastructure.exception;

import java.io.Serializable;

/**
 * Clase para mostrar mensaje de error en la llamada de servicios REST
 */
public class ErrorView implements Serializable {

    /**
     * Mensaje con el error a mostrar
     */
    private String errorMessage;

    /**
     * Mensaje con el error a mostrar
     */
    private String errorCode;

    public ErrorView(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}