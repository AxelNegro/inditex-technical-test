package com.inditex.technicaltest.infraestructure.repository;

import com.inditex.technicaltest.infraestructure.repository.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandsRepository extends JpaRepository<BrandEntity, Long> {
}
