package com.oandujar.domain.exception;

import lombok.Getter;

@Getter
public enum BusinessErrorType implements ErrorType {

    PRODUCT_NOT_FOUND(1000, "Product %s does not exists"),
    PRICE_NOT_FOUND(1000, "Price %s does not exists"),
    ERROR(1002, "An unexpected error has occurred");

    private String description;
    private Integer code;

    BusinessErrorType(int code, String description) {
        this.description = description;
        this.code = code;
    }

    @Override
    public String getName() {
        return this.name();
    }

}
