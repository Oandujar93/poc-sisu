package com.oandujar.infrastructure.persistence.mapper;

import com.oandujar.domain.entity.Prices;
import com.oandujar.domain.entity.Product;
import com.oandujar.domain.shared.PageItems;
import com.oandujar.infrastructure.persistence.entity.PricesEntity;
import com.oandujar.infrastructure.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.data.domain.Page;

@Mapper
public interface ProductEntityMapper {

    @Mapping(source = "number", target = "page")
    @Mapping(source = "first", target = "isFirst")
    @Mapping(source = "last", target = "isLast")
    @Mapping(source = "content", target = "items", qualifiedByName = "mapProductEntityToProduct")
    PageItems<Product> mapPageItemsProductEntityToPageItemsProduct(Page<ProductEntity> productEntityPage);

    @Named("mapProductEntityToProduct")
    @Mapping(source = "prices", target = "prices", qualifiedByName = "mapPricesEntityToPrices")
    Product mapProductEntityToProduct(ProductEntity productEntity);

    @Named("mapPricesEntityToPrices")
    Prices mapPricesEntityToPrices(PricesEntity pricesEntity);

    ProductEntity mapProductToProductEntity(Product product);
}
