package com.oandujar.domain.repository;


import com.oandujar.domain.entity.Prices;
import com.oandujar.domain.filter.PriceFilter;

import java.time.OffsetDateTime;
import java.util.Optional;

public interface PricesRepository {
    Optional<Prices> searchCurrentProductPrice(PriceFilter filter);
}
