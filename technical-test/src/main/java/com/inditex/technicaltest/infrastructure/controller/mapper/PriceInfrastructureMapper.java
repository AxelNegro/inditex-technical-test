package com.inditex.technicaltest.infrastructure.controller.mapper;

import com.inditex.technicaltest.domain.model.PriceModel;
import com.inditex.technicaltest.infrastructure.controller.dto.PriceDto;
import org.mapstruct.Mapper;

@Mapper
public interface PriceInfrastructureMapper {
    PriceDto convert(PriceModel priceModel);
}
