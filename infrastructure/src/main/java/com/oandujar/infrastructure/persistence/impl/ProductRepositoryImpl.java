package com.oandujar.infrastructure.persistence.impl;

import com.oandujar.domain.entity.Product;
import com.oandujar.domain.filter.ProductFilter;
import com.oandujar.domain.repository.ProductRepository;
import com.oandujar.domain.shared.PageItems;
import com.oandujar.infrastructure.persistence.ProductEntityRepository;
import com.oandujar.infrastructure.persistence.entity.PricesEntity;
import com.oandujar.infrastructure.persistence.entity.ProductEntity;
import com.oandujar.infrastructure.persistence.mapper.PageRequestMapper;
import com.oandujar.infrastructure.persistence.mapper.ProductEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductEntityRepository productEntityRepository;
    private final ProductEntityMapper productEntityMapper;
    private final PageRequestMapper pageRequestMapper;

    @Override
    public Optional<Product> searchProductById(Long productId) {
        return productEntityRepository.findById(productId)
                .map(productEntityMapper::mapProductEntityToProduct);
    }

    @Override
    public PageItems<Product> searchPaginatedProductsByFilter(ProductFilter filter) {
        Specification<ProductEntity> specification = getFilterSpecification(filter);
        Page<ProductEntity> pageProductsEntity = productEntityRepository.findAll(
                specification,
                pageRequestMapper.mapDomainPageRequestToPageRequest(filter.getPageRequest())
        );

        return productEntityMapper.mapPageItemsProductEntityToPageItemsProduct(pageProductsEntity);
    }

    private Specification<ProductEntity> getFilterSpecification(ProductFilter filter) {
        return ((root, query, criteriaBuilder) -> {
            Stream<Optional<Predicate>> predicateStream = Stream.of(
                    Optional.ofNullable(filter.getProductId())
                            .map(productId -> criteriaBuilder.equal(root.get("id"), productId)),
                    Optional.ofNullable(filter.getBrandId())
                            .map(brandId -> criteriaBuilder.equal(root.get("brandId"), brandId))
            );

            Predicate[] predicates = predicateStream
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .toArray(Predicate[]::new);

            query.groupBy(root.get("id"));

            return criteriaBuilder.and(predicates);
        });
    }


}
