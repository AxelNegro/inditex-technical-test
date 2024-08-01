package com.inditex.technicaltest.domain.port.out.impl;

import com.inditex.technicaltest.domain.model.Price;
import com.inditex.technicaltest.domain.model.mapper.PriceMapper;
import com.inditex.technicaltest.domain.port.out.PricesRepo;
import com.inditex.technicaltest.infraestructure.repository.PricesRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PricesRepoImpl implements PricesRepo {
    private final PricesRepository pricesRepository;
    private final PriceMapper mapper = Mappers.getMapper(PriceMapper.class);

    @Override
    public List<Price> findByProductIdBrandIdAndApplicationDate(Long productId, Long brandId, LocalDateTime applicationDate) {
        return pricesRepository.findByProductIdBrandIdAndApplicationDate(productId, brandId, applicationDate)
                .stream().map(mapper::convert)
                .toList();
    }
}
