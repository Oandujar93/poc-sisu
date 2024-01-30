package com.oandujar.infrastructure.rest;

import com.oandujar.domain.entity.Prices;
import com.oandujar.domain.entity.Product;
import com.oandujar.domain.filter.PriceFilter;
import com.oandujar.domain.filter.ProductFilter;
import com.oandujar.domain.shared.PageItems;
import com.oandujar.domain.usecases.SearchCurrentProductPriceUseCase;
import com.oandujar.domain.usecases.SearchProductUseCase;
import com.oandujar.infrastructure.rest.mapper.PriceRestMapper;
import com.oandujar.infrastructure.rest.mapper.ProductRestMapper;
import com.oandujar.infrastructure.web.api.ProductApi;
import com.oandujar.infrastructure.web.api.model.PageProductPriceResponse;
import com.oandujar.infrastructure.web.api.model.PriceResponse;
import com.oandujar.infrastructure.web.api.model.ProductPriceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductQueryController extends Controller implements ProductApi {

    private final SearchProductUseCase searchProductUseCase;
    private final SearchCurrentProductPriceUseCase searchCurrentProductPriceUseCase;
    private final ProductRestMapper productRestMapper;
    private final PriceRestMapper priceRestMapper;

    @Override
    public ResponseEntity<PriceResponse> getProductPrice(Long productId,
                                                         Long brandId,
                                                         String applicationDate) {
        final PriceFilter priceFilter = priceRestMapper.mapPriceFilterRequestToPriceFilter(
                productId,
                brandId,
                applicationDate
        );

        Optional<Prices> result = searchCurrentProductPriceUseCase.searchCurrentProductPrice(priceFilter);

        return ResponseEntity.ok(priceRestMapper.mapPricesToPriceResponse(result.get()));
    }

    @Override
    public ResponseEntity<ProductPriceResponse> getProductById(Long productId) {
        Optional<Product> result = searchProductUseCase.searchProductById(productId);
        return ResponseEntity.ok(productRestMapper.mapProductToProductPriceResponse(result.get()));
    }

    @Override
    public ResponseEntity<PageProductPriceResponse> getProducts(Long productId, Long brandId, Integer page, Integer size, String sort) {
        final ProductFilter productFilter = productRestMapper.mapProductFilterRequestToProductFilter(
                productId, brandId, PageRequest.of(page, size, stringToSort(sort))
        );

        PageItems<Product> result = searchProductUseCase.searchPaginatedProductsByFilter(productFilter);

        return ResponseEntity.ok(productRestMapper.mapPageItemsProductToProductPriceResponse(result));
    }

}
