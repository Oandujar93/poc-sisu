package com.oandujar.infrastructure.rest;

import org.springframework.data.domain.Sort;

public class Controller {

    public static Sort stringToSort(String sortString) {
        String[] parts = sortString.split(",");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid format. Expected 'field,direction'");
        }

        String field = parts[0];
        Sort.Direction direction = Sort.Direction.fromString(parts[1]);

        return Sort.by(direction, field);
    }
}
