package com.oandujar.application.usecase;

import com.oandujar.domain.entity.Prices;
import com.oandujar.domain.exception.BusinessErrorType;
import com.oandujar.domain.exception.BusinessException;
import com.oandujar.domain.filter.PriceFilter;
import com.oandujar.domain.repository.PricesRepository;
import com.oandujar.domain.usecases.SearchCurrentProductPriceUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SearchCurrentProductPriceUseCaseImpl implements SearchCurrentProductPriceUseCase {

    private final PricesRepository pricesRepository;

    @Override
    public Optional<Prices> searchCurrentProductPrice(PriceFilter filter) {
        Optional<Prices> result = pricesRepository.searchCurrentProductPrice(filter);

        if (result == null) {
            throw new BusinessException(BusinessErrorType.PRICE_NOT_FOUND, String.valueOf(filter.getProductId()));
        }

        return result;
    }
}
