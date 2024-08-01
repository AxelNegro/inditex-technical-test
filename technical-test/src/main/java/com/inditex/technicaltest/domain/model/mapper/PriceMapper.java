package com.inditex.technicaltest.domain.model.mapper;

import com.inditex.technicaltest.domain.model.Price;
import com.inditex.technicaltest.infraestructure.repository.entity.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PriceMapper {
    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "brandId", source = "brand.id")
    Price convert(PriceEntity entity);
}
