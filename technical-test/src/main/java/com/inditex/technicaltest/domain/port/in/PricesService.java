package com.inditex.technicaltest.domain.port.in;

import com.inditex.technicaltest.domain.model.PriceModel;

import java.time.LocalDateTime;

public interface PricesService {
    PriceModel getByProductIdBrandIdAndApplicationDate(Long productId, Long brandId, LocalDateTime applicationDate);
}
