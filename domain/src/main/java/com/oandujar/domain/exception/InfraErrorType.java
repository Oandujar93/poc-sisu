package com.oandujar.domain.exception;

import lombok.Getter;

@Getter
public enum InfraErrorType implements ErrorType {

    PRICE_SELECTION("Problem trying to choose the price"),
    ORM_CONNECTION_ERROR("Problem trying to access the database"),
    PUBLISHING_PRODUCT_EVENT_ERROR("Unable to send the product update event");

    private String description;

    InfraErrorType(String description) {
        this.description = description;
    }

    @Override
    public String getName() {
        return description;
    }


}
