package com.inditex.technicaltest.domain.port.in;

import com.inditex.technicaltest.domain.model.Price;

import java.time.LocalDateTime;

public interface PricesService {
    Price getByProductIdBrandIdAndApplicationDate(Long productId, Long brandId, LocalDateTime applicationDate);
}
