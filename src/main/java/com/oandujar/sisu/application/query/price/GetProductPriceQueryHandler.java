package com.oandujar.sisu.application.query.price;

import com.oandujar.sisu.application.dto.response.ProductPriceFeeQueryResponse;
import com.oandujar.sisu.application.querybus.QueryHandler;
import com.oandujar.sisu.domain.model.Prices;
import com.oandujar.sisu.domain.port.PricesPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetProductPriceQueryHandler implements QueryHandler<ProductPriceFeeQueryResponse, GetProductPriceQuery> {

    private final PricesPort pricesPort;

    @Override
    public ProductPriceFeeQueryResponse handle(GetProductPriceQuery query) {
        Optional<Prices> pricesResponse = pricesPort.findByBrandIdProductIdAndBetweenStartDateAndEndDate(
                query.brandId(), query.productId(), query.offsetDateTime()
        );

        return pricesResponse.isPresent() ? ProductPriceFeeQueryResponse.fromDomain(pricesResponse.get()) : null;
    }

}
