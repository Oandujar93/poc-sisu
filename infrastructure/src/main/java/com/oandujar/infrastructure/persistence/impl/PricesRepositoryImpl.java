package com.oandujar.infrastructure.persistence.impl;

import com.oandujar.domain.entity.Prices;
import com.oandujar.domain.entity.Product;
import com.oandujar.domain.filter.PriceFilter;
import com.oandujar.domain.filter.ProductFilter;
import com.oandujar.domain.repository.PricesRepository;
import com.oandujar.domain.shared.PageItems;
import com.oandujar.infrastructure.persistence.PricesEntityRepository;
import com.oandujar.infrastructure.persistence.entity.PricesEntity;
import com.oandujar.infrastructure.persistence.entity.ProductEntity;
import com.oandujar.infrastructure.persistence.mapper.PriceEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class PricesRepositoryImpl implements PricesRepository {

    private final PricesEntityRepository pricesEntityRepository;
    private final PriceEntityMapper priceEntityMapper;

    @Override
    public Optional<Prices> searchCurrentProductPrice(PriceFilter filter) {
        Specification<PricesEntity> specification = getFilterSpecification(filter);
        Page<PricesEntity> pagePricesEntity = pricesEntityRepository.findAll(
                specification,
                PageRequest.of(0,1, Sort.by(Sort.Direction.DESC, "priority", "fee"))
        );
        return pagePricesEntity.stream().findFirst()
                .map(priceEntityMapper::mapPricesEntityToPrices);
    }

    private Specification<PricesEntity> getFilterSpecification(PriceFilter filter) {
        return ((root, query, criteriaBuilder) -> {
            Join<PricesEntity, ProductEntity> productJoin = root.join("product");

            Stream<Optional<Predicate>> predicateStream = Stream.of(
                    Optional.ofNullable(filter.getProductId())
                            .map(productId -> criteriaBuilder.equal(root.get("productId"), productId)),
                    Optional.ofNullable(filter.getBrandId())
                            .map(brandId -> criteriaBuilder.equal(productJoin.get("brandId"), brandId)),
                    Optional.ofNullable(filter.getApplicationDate())
                            .map(applicationDate -> criteriaBuilder.between(
                                    criteriaBuilder.literal(applicationDate),
                                    root.get("startDate"),
                                    root.get("endDate"))
                            )
            );

            Predicate[] predicates = predicateStream
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .toArray(Predicate[]::new);

            return criteriaBuilder.and(predicates);
        });
    }

}
