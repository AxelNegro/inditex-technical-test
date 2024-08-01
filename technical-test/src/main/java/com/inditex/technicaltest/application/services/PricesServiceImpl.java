package com.inditex.technicaltest.application.services;

import com.inditex.technicaltest.common.enums.InditexExceptionsEnum;
import com.inditex.technicaltest.common.exceptions.InditexException;
import com.inditex.technicaltest.domain.model.Price;
import com.inditex.technicaltest.domain.port.in.PricesService;
import com.inditex.technicaltest.domain.port.out.PricesRepo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PricesServiceImpl implements PricesService {
    @Autowired
    private PricesRepo pricesRepo;

    @Override
    @SneakyThrows
    public Price getByProductIdBrandIdAndApplicationDate(Long productId, Long brandId, LocalDateTime applicationDate) {
        List<Price> prices = pricesRepo.findByProductIdBrandIdAndApplicationDate(productId, brandId, applicationDate);

        if(prices.isEmpty())
            throw new InditexException(InditexExceptionsEnum.ERROR_701_EMPTY_PRICES.getMessageDto());

        Price finalPrice = null;

        for (Price p : prices) {
            if(finalPrice == null || finalPrice.getPriority() < p.getPriority())
                finalPrice = p;
        }

        return finalPrice;
    }
}
