package com.inditex.technicaltest.domain.port.out;

import com.inditex.technicaltest.domain.model.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PricesRepo {
    List<Price> findByProductIdBrandIdAndApplicationDate(Long productId, Long brandId, LocalDateTime applicationDate);
}
