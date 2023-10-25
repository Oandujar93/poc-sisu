package com.oandujar.sisu.infraestructure.port;

import com.oandujar.sisu.domain.model.Prices;
import com.oandujar.sisu.domain.port.PricesPort;
import com.oandujar.sisu.infraestructure.port.repository.PricesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PricesPortImpl implements PricesPort {

    private final PricesRepository pricesRepository;

    @Override
    public Optional<Prices> findByBrandIdProductIdAndBetweenStartDateAndEndDate(Long brandId, Long productId, OffsetDateTime date) {
        return pricesRepository.findFirstByBrandIdProductIdAndBetweenStartDateAndEndDateOrderByPriority(
                brandId,
                productId,
                date);
    }
}
