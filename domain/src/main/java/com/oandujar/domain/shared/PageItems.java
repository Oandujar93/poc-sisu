package com.oandujar.domain.shared;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageItems<T> {
    private List<T> items;
    private Long totalElements;
    private Long totalPages;
    private Boolean isFirst;
    private Boolean isLast;
    private Integer page;
    private Integer size;
}
