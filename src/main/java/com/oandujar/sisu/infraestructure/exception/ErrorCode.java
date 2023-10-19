package com.oandujar.sisu.infraestructure.exception;

public enum ErrorCode {

    ACCESS_DENIED("Acceso no permitido al objeto u operacion"),
    PARSE_ERROR("Problema al convertir entidad en dto"),
    EMPTY_PARAM_CALL_ERROR("{0}"),
    ORM_ACCESS_ERROR("No es posible acceder al origen de datos"),
    NOT_FOUND("Entidad no encontrada"),
    UNKNOWN("Desconocido");

    /**
     * Código de la excepción
     */
    private final String code;

    /**
     * Mensaje adicional de la excepción
     */
    private final String message;

    /**
     * Constructor
     * <p>
     * Permite indicar un mensaje adicional que se guarda junto al mensaje
     * básico asociado al código
     *
     * @param message
     *            Mensaje adicional
     */
    ErrorCode(final String message) {
        this.code = this.name();
        this.message = message;
    }

    /**
     * Retorna el código de la excepción
     *
     * @return Código de la excepción
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Retorna el mensaje adicional de la excepción
     *
     * @return Mensaje de la excepción
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Conversión de la clase a String
     *
     * @return El código de la excepción en texto
     */
    @Override
    public String toString() {
        return this.code;
    }
}
