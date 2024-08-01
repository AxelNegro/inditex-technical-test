package com.inditex.technicaltest.application.services;

import com.inditex.technicaltest.common.enums.InditexExceptionsEnum;
import com.inditex.technicaltest.common.exceptions.InditexException;
import com.inditex.technicaltest.domain.model.PriceModel;
import com.inditex.technicaltest.domain.port.in.PricesService;
import com.inditex.technicaltest.domain.port.out.PricesRepo;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PricesServiceImpl implements PricesService {
    private final PricesRepo pricesRepo;

    @Override
    @SneakyThrows
    public PriceModel getByProductIdBrandIdAndApplicationDate(Long productId, Long brandId, LocalDateTime applicationDate) {
        List<PriceModel> priceModels = pricesRepo.findByProductIdBrandIdAndApplicationDate(productId, brandId, applicationDate);

        if(priceModels.isEmpty())
            throw new InditexException(InditexExceptionsEnum.ERROR_701_EMPTY_PRICES.getMessageDto());

        PriceModel finalPriceModel = null;

        for (PriceModel p : priceModels) {
            if(finalPriceModel == null || finalPriceModel.getPriority() < p.getPriority())
                finalPriceModel = p;
        }

        return finalPriceModel;
    }
}
