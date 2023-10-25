package com.oandujar.sisu.domain.usecase;


import com.oandujar.sisu.web.api.model.ProductPriceResponse;

import java.time.OffsetDateTime;

public interface GetProductFeeUseCase {

    ProductPriceResponse execute(Long productId, Long brandId, OffsetDateTime date);

}
