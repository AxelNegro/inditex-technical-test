package com.inditex.technicaltest.infraestructure.repository;

import com.inditex.technicaltest.infraestructure.repository.entity.PriceEntity;
import com.inditex.technicaltest.infraestructure.repository.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<ProductEntity, Long> {
}
