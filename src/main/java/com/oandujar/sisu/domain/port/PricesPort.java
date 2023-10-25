package com.oandujar.sisu.domain.port;

import com.oandujar.sisu.domain.model.Prices;

import java.time.OffsetDateTime;
import java.util.Optional;

public interface PricesPort {

    Optional<Prices> findByBrandIdProductIdAndBetweenStartDateAndEndDate(Long brandId, Long productId, OffsetDateTime date);

}
