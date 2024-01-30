package com.oandujar.infrastructure.persistence.impl;

import com.oandujar.domain.entity.Prices;
import com.oandujar.domain.filter.PriceFilter;
import com.oandujar.domain.repository.PricesRepository;
import com.oandujar.infrastructure.persistence.PricesEntityRepository;
import com.oandujar.infrastructure.persistence.entity.PricesEntity;
import com.oandujar.infrastructure.persistence.mapper.PriceEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PricesRepositoryImpl implements PricesRepository {

    private final PricesEntityRepository pricesEntityRepository;
    private final PriceEntityMapper priceEntityMapper;

    @Override
    public Optional<Prices> searchCurrentProductPrice(PriceFilter filter) {
        Optional<PricesEntity> pricesEntity =
                pricesEntityRepository.findFirstByProduct_BrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                        filter.getBrandId(),
                        filter.getProductId(),
                        filter.getApplicationDate(),
                        filter.getApplicationDate()
                );
        return pricesEntity.map(priceEntityMapper::mapPricesEntityToPrices);
    }

}
