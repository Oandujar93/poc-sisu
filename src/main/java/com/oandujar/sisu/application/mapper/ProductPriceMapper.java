package com.oandujar.sisu.application.mapper;

import com.oandujar.sisu.domain.model.Prices;
import com.oandujar.sisu.web.api.model.ProductPriceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper
public interface ProductPriceMapper {

    Prices dtoToDomain(ProductPriceResponse src);

    @Mapping(target = "brand", source = "src.brand.name")
    @Mapping(target = "name", source = "src.product.name")
    @Mapping(target = "description", source = "src.product.description")
    @Mapping(target = "priority", source = "src.priority")
    @Mapping(target = "fee", source = "src.priceList")
    @Mapping(target = "price", source = "src.price", qualifiedByName = "priceToDecimalString")
    @Mapping(target = "startDate", source = "src.startDate")
    @Mapping(target = "endDate", source = "src.endDate")
    ProductPriceResponse domainToDTO(Prices src);

    @Named("priceToDecimalString")
    default String priceToDecimalString(Double price) {
        if (price == null) {
            return null;
        }

        return String.format("%.2f", price);
    }

}
