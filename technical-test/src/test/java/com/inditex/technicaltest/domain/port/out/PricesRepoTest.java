package com.inditex.technicaltest.domain.port.out;

import com.inditex.technicaltest.common.BaseTestAnnotation;
import com.inditex.technicaltest.domain.model.PriceModel;
import com.inditex.technicaltest.infrastructure.repository.PricesRepository;
import com.inditex.technicaltest.infrastructure.repository.entity.BrandEntity;
import com.inditex.technicaltest.infrastructure.repository.entity.PriceEntity;
import com.inditex.technicaltest.infrastructure.repository.entity.ProductEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@BaseTestAnnotation
class PricesRepoTest {
    @Autowired
    private PricesRepo pricesRepo;
    @MockBean
    private PricesRepository pricesRepository;

    @Test
    void Given_RepositoryReturnNull_When_FindByProductIdAndBrandId_Then_ReturnEmpty(){
        when(pricesRepository.findByProductIdBrandIdAndApplicationDate(anyLong(), anyLong(), any(LocalDateTime.class))).thenReturn(null);

        PriceModel actual = pricesRepo.findByProductIdBrandIdAndApplicationDate(1L, 1L, LocalDateTime.now());

        assertThat(actual).isNull();
    }

    @Test
    void Given_HappyPath_When_FindByProductIdAndBrandId_Then_Success(){
        PriceEntity priceEntity = getPriceEntity();
        PriceModel expected = getPrice();

        when(pricesRepository.findByProductIdBrandIdAndApplicationDate(anyLong(), anyLong(), any(LocalDateTime.class))).thenReturn(priceEntity);

        PriceModel actual = pricesRepo.findByProductIdBrandIdAndApplicationDate(1L, 1L, LocalDateTime.now());

        assertThat(actual).isNotNull();
        assertEquals(expected, actual);

        verify(pricesRepository, times(1)).findByProductIdBrandIdAndApplicationDate(anyLong(), anyLong(), any(LocalDateTime.class));
    }

    private PriceModel getPrice() {
        PriceModel priceModel = new PriceModel();

        priceModel.setId(1L);
        priceModel.setProductId(1L);
        priceModel.setBrandId(1L);
        priceModel.setStartDate(LocalDateTime.of(2022, 1, 1, 12, 0, 0));
        priceModel.setEndDate(LocalDateTime.of(2022, 12, 31, 12, 0, 0));
        priceModel.setPriority(0);
        priceModel.setPrice(35.50);
        priceModel.setCurrency("EUR");

        return priceModel;
    }

    private PriceEntity getPriceEntity() {
        PriceEntity priceEntity = new PriceEntity();

        priceEntity.setId(1L);
        priceEntity.setProduct(getProductEntity());
        priceEntity.setBrand(getBrandEntity());
        priceEntity.setStartDate(LocalDateTime.of(2022, 1, 1, 12, 0, 0));
        priceEntity.setEndDate(LocalDateTime.of(2022, 12, 31, 12, 0, 0));
        priceEntity.setPriority(0);
        priceEntity.setPrice(35.50);
        priceEntity.setCurrency("EUR");

        return priceEntity;
    }


    private ProductEntity getProductEntity() {
        return new ProductEntity(1L, "SHOES");
    }


    private BrandEntity getBrandEntity() {
        return new BrandEntity(1L, "SHOES");
    }
}
