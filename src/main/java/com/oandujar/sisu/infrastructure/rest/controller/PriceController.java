package com.oandujar.sisu.infrastructure.rest.controller;

import com.oandujar.sisu.domain.usecase.GetProductFeeUseCase;
import com.oandujar.sisu.web.api.PriceApi;
import com.oandujar.sisu.web.api.model.ProductPriceResponse;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@Slf4j
@RestController
@OpenAPIDefinition(info = @Info(title = "Price", version = "v1"))
@RequiredArgsConstructor
public class PriceController implements PriceApi {

    private final GetProductFeeUseCase getProductFeeUseCase;

    @Override
    public ResponseEntity<ProductPriceResponse> getProductPrice(
            Long brandId,
            Long productId,
            OffsetDateTime offsetDateTime) {
        return ResponseEntity.ok(getProductFeeUseCase.execute(productId, brandId, offsetDateTime));
    }

}
