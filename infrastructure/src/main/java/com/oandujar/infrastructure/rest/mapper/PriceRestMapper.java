package com.oandujar.infrastructure.rest.mapper;

import com.oandujar.domain.entity.Prices;
import com.oandujar.domain.entity.Product;
import com.oandujar.domain.filter.PriceFilter;
import com.oandujar.domain.shared.Direction;
import com.oandujar.domain.shared.Order;
import com.oandujar.infrastructure.web.api.model.PriceResponse;
import com.oandujar.infrastructure.web.api.model.ProductPriceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface PriceRestMapper {

    @Mapping(source = "pageable.pageNumber", target = "pageRequest.page")
    @Mapping(source = "pageable.pageSize", target = "pageRequest.size")
    @Mapping(source = "pageable.sort", target = "pageRequest.orders", qualifiedByName = "mapSortToListOrder")
    @Mapping(source = "applicationDate", target = "applicationDate", qualifiedByName = "mapStringToOffsetDateTime")
    PriceFilter mapPriceFilterRequestToPriceFilter(Long productId,
                                                   Long brandId,
                                                   String applicationDate,
                                                   Pageable pageable);

    @Named("mapStringToOffsetDateTime")
    default OffsetDateTime mapStringToOffsetDateTime(String applicationDate) {
        return OffsetDateTime.parse(applicationDate.replace(" ", "+"));
    }

    @Named("mapSortToListOrder")
    default List<Order> mapSortToListOrder(Sort sort) {
        if (sort == null) {
            return Collections.emptyList();
        }
        return sort.get()
                .map(x -> Order.builder()
                        .property(x.getProperty())
                        .direction(Direction.valueOf(x.getDirection().name()))
                        .build()
                ).collect(Collectors.toList());
    }


    PriceResponse mapPricesToPriceResponse(Prices result);

}
