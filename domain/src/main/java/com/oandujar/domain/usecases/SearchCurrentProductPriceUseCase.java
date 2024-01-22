package com.oandujar.domain.usecases;

import com.oandujar.domain.entity.Prices;
import com.oandujar.domain.filter.PriceFilter;

import java.util.Optional;

public interface SearchCurrentProductPriceUseCase {
    Optional<Prices> searchCurrentProductPrice(PriceFilter filter);
}
