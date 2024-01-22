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
public class PageRequest {

    private Integer size;
    private Integer page;
    private List<Order> orders;

}
