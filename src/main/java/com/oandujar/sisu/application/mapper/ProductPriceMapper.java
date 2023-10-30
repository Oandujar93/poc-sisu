package com.oandujar.sisu.application.mapper;

import com.oandujar.sisu.application.dto.response.ProductPriceFeeQueryResponse;
import com.oandujar.sisu.web.api.model.ProductPriceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ProductPriceMapper {

    ProductPriceFeeQueryResponse dtoToDomain(ProductPriceResponse src);

    @Mapping(target = "fee", source = "src.priceList")
    @Mapping(target = "price", source = "src.price", qualifiedByName = "priceToDecimalString")
    ProductPriceResponse domainToDTO(ProductPriceFeeQueryResponse src);

    @Named("priceToDecimalString")
    default String priceToDecimalString(Double price) {
        if (price == null) {
            return null;
        }

        return String.format("%.2f", price).replace(".", ",");
    }

}
