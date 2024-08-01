package com.inditex.technicaltest.domain.port.out;

import com.inditex.technicaltest.domain.model.Price;

import java.util.List;

public interface PricesRepo {
    List<Price> findByProductIdAndBrandId(Long productId, Long brandId);
}
