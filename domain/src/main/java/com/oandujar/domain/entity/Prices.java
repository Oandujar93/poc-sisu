package com.oandujar.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Prices {
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private Long fee;
    private Double price;
    private String currency;
    private Integer priority;
}

