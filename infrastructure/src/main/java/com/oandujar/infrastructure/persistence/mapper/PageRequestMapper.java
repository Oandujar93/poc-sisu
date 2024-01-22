package com.oandujar.infrastructure.persistence.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;


@Mapper
public interface PageRequestMapper {

    default PageRequest mapDomainPageRequestToPageRequest(com.oandujar.domain.shared.PageRequest pageRequest) {
        if (pageRequest == null) {
            return null;
        }

        List<Sort.Order> orders = pageRequest.getOrders().stream()
                .map(order -> new Sort.Order(
                        Sort.Direction.fromString(order.getDirection().name()),
                        order.getProperty()))
                .collect(Collectors.toList());

        return PageRequest.of(pageRequest.getPage(), pageRequest.getSize(), Sort.by(orders));
    }
}
