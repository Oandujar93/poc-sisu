package com.oandujar.sisu.infrastructure.port.repository;

import com.oandujar.sisu.domain.model.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.Optional;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Long> {

    @Query(value = "SELECT * FROM prices e " +
            "WHERE (:brandId IS NULL OR e.brand_id = :brandId) " +
            "AND (:productId IS NULL OR e.product_id = :productId) " +
            "AND (:offsetDateTime IS NULL OR :offsetDateTime BETWEEN e.start_date AND e.end_date) " +
            "ORDER BY e.priority DESC LIMIT 1", nativeQuery = true)
    Optional<Prices> findFirstByBrandIdProductIdAndBetweenStartDateAndEndDateOrderByPriority(
            @Param("brandId") Long brandId,
            @Param("productId") Long productId,
            @Param("offsetDateTime") OffsetDateTime offsetDateTime
    );

}
