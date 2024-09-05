package com.inditex.technicaltest.infrastructure.repository;

import com.inditex.technicaltest.infrastructure.repository.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PricesRepository extends JpaRepository<PriceEntity, Long> {
    @Query(value = """
            SELECT P.*
            FROM PRICES P
            WHERE PRODUCT_ID = ?1
            AND BRAND_ID = ?2
            AND ?3 BETWEEN START_DATE AND END_DATE
            ORDER BY PRIORITY DESC
            FETCH FIRST ROW ONLY
            """, nativeQuery = true)
    PriceEntity findByProductIdBrandIdAndApplicationDate(Long productId, Long brandId, LocalDateTime applicationDate);
}
