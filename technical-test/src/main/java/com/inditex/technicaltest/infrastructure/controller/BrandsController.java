package com.inditex.technicaltest.infrastructure.controller;

import com.inditex.technicaltest.domain.port.in.PricesService;
import com.inditex.technicaltest.infrastructure.controller.dto.PriceDto;
import com.inditex.technicaltest.infrastructure.controller.mapper.PriceInfrastructureMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BrandsController implements BrandsApi {
    private final PricesService pricesService;
    private final PriceInfrastructureMapper priceInfrastructureMapper = Mappers.getMapper(PriceInfrastructureMapper.class);
    @Override
    public ResponseEntity<PriceDto> getBrandsBrandIdProductsProductIdPrices(Long brandId, Long productId, LocalDateTime applicationDate) {
        log.info("Getting product price by product id {}, brand id {} and application date {}", productId, brandId, applicationDate);

        PriceDto priceDto = priceInfrastructureMapper.convert(pricesService.getByProductIdBrandIdAndApplicationDate(productId, brandId, applicationDate));

        log.info("Finished getting product price");

        return ResponseEntity.ok(priceDto);
    }
}
