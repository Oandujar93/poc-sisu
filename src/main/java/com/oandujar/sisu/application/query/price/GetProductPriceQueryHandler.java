package com.oandujar.sisu.application.query.price;

import com.oandujar.sisu.application.mapper.ProductPriceMapper;
import com.oandujar.sisu.application.querybus.QueryHandler;
import com.oandujar.sisu.domain.model.Prices;
import com.oandujar.sisu.domain.port.PricesPort;
import com.oandujar.sisu.web.api.model.ProductPriceResponse;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetProductPriceQueryHandler implements QueryHandler<List<ProductPriceResponse>, GetProductPriceQuery> {

    private final PricesPort pricesPort;
    private final ProductPriceMapper productPriceMapper = Mappers.getMapper(ProductPriceMapper.class);

    @Override
    public List<ProductPriceResponse> handle(GetProductPriceQuery query) {
        List<Prices> pricesPageResponse = pricesPort.findByBrandIdProductIdAndBetweenStartDateAndEndDate(
                query.brandId(), query.productId(), query.offsetDateTime()
        );

        return pricesPageResponse.stream()
                .map(productPriceMapper::domainToDTO)
                .collect(Collectors.toList());
    }

}
