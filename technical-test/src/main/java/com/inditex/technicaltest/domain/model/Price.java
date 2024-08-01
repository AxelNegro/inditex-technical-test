package com.inditex.technicaltest.domain.model;

import com.inditex.technicaltest.infraestructure.repository.entity.BrandEntity;
import com.inditex.technicaltest.infraestructure.repository.entity.ProductEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Price {
    private Long id;
    private Long productId;
    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priority;
    private Double price;
    private String currency;
}
