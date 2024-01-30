package com.oandujar.infrastructure.persistence;

import com.oandujar.infrastructure.persistence.entity.PricesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.OffsetDateTime;
import java.util.Optional;

public interface PricesEntityRepository extends JpaRepository<PricesEntity, Long>, JpaSpecificationExecutor<PricesEntity> {

    Optional<PricesEntity> findFirstByProduct_BrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            Long brandId, Long productId, OffsetDateTime startDate, OffsetDateTime endDate);

}
