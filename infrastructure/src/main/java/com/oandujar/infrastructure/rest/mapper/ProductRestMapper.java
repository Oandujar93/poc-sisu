package com.oandujar.infrastructure.rest.mapper;

import com.oandujar.domain.entity.Product;
import com.oandujar.domain.filter.ProductFilter;
import com.oandujar.domain.shared.Direction;
import com.oandujar.domain.shared.Order;
import com.oandujar.domain.shared.PageItems;
import com.oandujar.infrastructure.web.api.model.PageProductPriceResponse;
import com.oandujar.infrastructure.web.api.model.ProductPriceResponse;
import com.oandujar.infrastructure.web.api.model.SearchProductFilterRequest;
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
public interface ProductRestMapper {

    @Mapping(source = "pageable.pageNumber", target = "pageRequest.page")
    @Mapping(source = "pageable.pageSize", target = "pageRequest.size")
    @Mapping(source = "pageable.sort", target = "pageRequest.orders", qualifiedByName = "mapSortToListOrder")
    ProductFilter mapProductFilterRequestToProductFilter(Long productId, Long brandId, Pageable pageable);

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

    @Mapping(source = "size", target = "pageSize")
    @Mapping(source = "page", target = "pageNumber")
    @Mapping(source = "items", target = "content", qualifiedByName = "mapProductToProductPriceResponses")
    PageProductPriceResponse mapPageItemsProductToProductPriceResponse(PageItems<Product> result);

    @Named("mapProductToProductPriceResponses")
    default List<ProductPriceResponse> mapProductToProductPriceResponses(List<Product> products) {
        return products != null ? products.stream()
                .map(this::mapProductToProductPriceResponse)
                .collect(Collectors.toList()) : new ArrayList<>();
    }

    ProductPriceResponse mapProductToProductPriceResponse(Product product);
}
