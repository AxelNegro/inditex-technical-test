package com.inditex.technicaltest.domain.model.mapper;

import com.inditex.technicaltest.domain.model.PriceModel;
import com.inditex.technicaltest.infrastructure.repository.entity.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PriceDomainMapper {
    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "brandId", source = "brand.id")
    PriceModel convert(PriceEntity entity);
}
