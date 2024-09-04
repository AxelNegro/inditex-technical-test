package com.inditex.technicaltest.domain.port.out;

import com.inditex.technicaltest.domain.model.PriceModel;

import java.time.LocalDateTime;

public interface PricesRepo {
    PriceModel findByProductIdBrandIdAndApplicationDate(Long productId, Long brandId, LocalDateTime applicationDate);
}
