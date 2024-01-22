package com.oandujar.application.query.price;


import com.oandujar.application.querybus.QueryHandler;
import com.oandujar.domain.entity.Prices;
import com.oandujar.domain.entity.Product;
import com.oandujar.domain.repository.PricesRepository;
import com.oandujar.domain.repository.ProductRepository;
import com.oandujar.domain.shared.PageItems;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetPriceFilterQueryHandler implements QueryHandler<Optional<Prices>, GetPriceFilterQuery> {

    private final PricesRepository pricesRepository;

    @Override
    public Optional<Prices> handle(GetPriceFilterQuery query) {
        return pricesRepository.searchCurrentProductPrice(query.filter());
    }
}
