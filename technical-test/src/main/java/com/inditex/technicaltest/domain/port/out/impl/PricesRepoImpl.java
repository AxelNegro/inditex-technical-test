package com.inditex.technicaltest.domain.port.out.impl;

import com.inditex.technicaltest.domain.model.PriceModel;
import com.inditex.technicaltest.domain.model.mapper.PriceDomainMapper;
import com.inditex.technicaltest.domain.port.out.PricesRepo;
import com.inditex.technicaltest.infrastructure.repository.PricesRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PricesRepoImpl implements PricesRepo {
    private final PricesRepository pricesRepository;
    private final PriceDomainMapper mapper = Mappers.getMapper(PriceDomainMapper.class);

    @Override
    public List<PriceModel> findByProductIdBrandIdAndApplicationDate(Long productId, Long brandId, LocalDateTime applicationDate) {
        return pricesRepository.findByProductIdBrandIdAndApplicationDate(productId, brandId, applicationDate)
                .stream().map(mapper::convert)
                .toList();
    }
}
