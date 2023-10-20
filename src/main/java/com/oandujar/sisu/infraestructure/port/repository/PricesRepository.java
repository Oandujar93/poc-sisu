package com.oandujar.sisu.infraestructure.port.repository;

import com.oandujar.sisu.domain.model.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Long> {

    @Query("SELECT e FROM Prices e " +
            "WHERE (:brandId IS NULL OR e.brandId = :brandId) " +
            "AND (:productId IS NULL OR e.productId = :productId) " +
            "AND (:offsetDateTime IS NULL OR :offsetDateTime BETWEEN e.startDate AND e.endDate)")
    List<Prices> findByBrandIdProductIdAndBetweenStartDateAndEndDate(
            @Param("brandId") Long brandId,
            @Param("productId") Long productId,
            @Param("offsetDateTime") OffsetDateTime offsetDateTime
    );

}
