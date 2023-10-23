package com.oandujar.sisu.application.query.price;

import com.oandujar.sisu.application.dto.response.ProductPriceFeeQueryResponse;
import com.oandujar.sisu.application.querybus.QueryHandler;
import com.oandujar.sisu.domain.model.Prices;
import com.oandujar.sisu.domain.port.PricesPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetProductPriceQueryHandler implements QueryHandler<List<ProductPriceFeeQueryResponse>, GetProductPriceQuery> {

    private final PricesPort pricesPort;

    @Override
    public List<ProductPriceFeeQueryResponse> handle(GetProductPriceQuery query) {
        List<Prices> pricesPageResponse = pricesPort.findByBrandIdProductIdAndBetweenStartDateAndEndDate(
                query.brandId(), query.productId(), query.offsetDateTime()
        );

        return pricesPageResponse.stream()
                .map(ProductPriceFeeQueryResponse::fromDomain)
                .collect(Collectors.toList());
    }

}
