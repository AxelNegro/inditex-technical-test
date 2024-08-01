package com.inditex.technicaltest.infrastructure.repository;

import com.inditex.technicaltest.infrastructure.repository.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandsRepository extends JpaRepository<BrandEntity, Long> {
}
