package com.oandujar.infrastructure.persistence.mapper;

import com.oandujar.domain.entity.Prices;
import com.oandujar.infrastructure.persistence.entity.PricesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PriceEntityMapper {

    Prices mapPricesEntityToPrices(PricesEntity pricesEntity);

}
