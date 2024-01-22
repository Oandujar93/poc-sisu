package com.oandujar.application.usecase;

import com.oandujar.application.query.price.GetPriceFilterQuery;
import com.oandujar.application.querybus.QueryBus;
import com.oandujar.domain.entity.Prices;
import com.oandujar.domain.exception.BusinessErrorType;
import com.oandujar.domain.exception.BusinessException;
import com.oandujar.domain.exception.InfraErrorType;
import com.oandujar.domain.exception.InfraException;
import com.oandujar.domain.filter.PriceFilter;
import com.oandujar.domain.usecases.SearchCurrentProductPriceUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SearchCurrentProductPriceUseCaseImpl implements SearchCurrentProductPriceUseCase {

    private final QueryBus queryBus;

    @Override
    public Optional<Prices> searchCurrentProductPrice(PriceFilter filter) {
        GetPriceFilterQuery query = GetPriceFilterQuery.Builder.getInstance()
                .create(filter)
                .build();
        Optional<Prices> result;
        try {
            result = queryBus.handle(query);
        } catch (Exception e) {
            throw new InfraException(InfraErrorType.ORM_CONNECTION_ERROR);
        }

        if (result == null) {
            throw new BusinessException(BusinessErrorType.PRODUCT_NOT_FOUND);
        }

        return result;
    }
}
