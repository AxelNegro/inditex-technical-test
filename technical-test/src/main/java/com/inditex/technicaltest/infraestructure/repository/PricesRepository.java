package com.inditex.technicaltest.infraestructure.repository;

import com.inditex.technicaltest.infraestructure.repository.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PricesRepository extends JpaRepository<PriceEntity, Long> {
    List<PriceEntity> findByProductIdAndBrandId(Long productId, Long brandId);
}
