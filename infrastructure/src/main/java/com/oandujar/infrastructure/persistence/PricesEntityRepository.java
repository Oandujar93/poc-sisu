package com.oandujar.infrastructure.persistence;

import com.oandujar.infrastructure.persistence.entity.PricesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PricesEntityRepository extends JpaRepository<PricesEntity, Long>, JpaSpecificationExecutor<PricesEntity> {
}
