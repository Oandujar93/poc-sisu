package com.oandujar.domain.filter;

import com.oandujar.domain.shared.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductFilter {
    private Long productId;
    private Long brandId;
    private PageRequest pageRequest;
}
