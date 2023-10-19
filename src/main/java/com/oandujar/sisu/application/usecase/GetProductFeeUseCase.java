package com.oandujar.sisu.application.usecase;


import com.oandujar.sisu.web.api.model.ProductPriceResponse;

import java.time.OffsetDateTime;
import java.util.List;

public interface GetProductFeeUseCase {

    List<ProductPriceResponse> execute(Long productId, Long brandId, OffsetDateTime date);

}
