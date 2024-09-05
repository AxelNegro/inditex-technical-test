package com.inditex.technicaltest.application.services;

import com.inditex.technicaltest.domain.common.enums.InditexExceptionsEnum;
import com.inditex.technicaltest.domain.common.exceptions.InditexException;
import com.inditex.technicaltest.domain.model.PriceModel;
import com.inditex.technicaltest.domain.port.in.PricesService;
import com.inditex.technicaltest.domain.port.out.PricesRepo;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PricesServiceImpl implements PricesService {
    private final PricesRepo pricesRepo;

    @Override
    @SneakyThrows
    public PriceModel getByProductIdBrandIdAndApplicationDate(Long productId, Long brandId, LocalDateTime applicationDate) {
        PriceModel priceModel = pricesRepo.findByProductIdBrandIdAndApplicationDate(productId, brandId, applicationDate);

        if(Objects.isNull(priceModel))
            throw new InditexException(InditexExceptionsEnum.ERROR_701_EMPTY_PRICES.getMessageDto());

        return priceModel;
    }
}
