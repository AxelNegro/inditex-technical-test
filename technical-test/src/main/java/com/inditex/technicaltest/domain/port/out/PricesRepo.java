package com.inditex.technicaltest.domain.port.out;

import com.inditex.technicaltest.domain.model.PriceModel;

import java.time.LocalDateTime;
import java.util.List;

public interface PricesRepo {
    List<PriceModel> findByProductIdBrandIdAndApplicationDate(Long productId, Long brandId, LocalDateTime applicationDate);
}
