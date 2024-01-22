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

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Mapper
public interface PriceRestMapper {

    @Mapping(source = "applicationDate", target = "applicationDate", qualifiedByName = "mapStringToOffsetDateTime")
    PriceFilter mapPriceFilterRequestToPriceFilter(Long productId,
                                                   Long brandId,
                                                   String applicationDate);

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


    @Mapping(source = "price", target = "price", qualifiedByName = "mapDoublePriceToStringPriceResponse")
    PriceResponse mapPricesToPriceResponse(Prices result);

    @Named("mapDoublePriceToStringPriceResponse")
    default String mapDoublePriceToStringPriceResponse(Double price) {
        if (price == null) {
            return null;
        }

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator(',');

        DecimalFormat format = new DecimalFormat("#.00", symbols);
        return format.format(price);
    }

}
