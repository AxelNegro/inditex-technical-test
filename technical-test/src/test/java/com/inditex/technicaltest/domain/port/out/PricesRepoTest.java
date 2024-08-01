package com.inditex.technicaltest.domain.port.out;

import com.inditex.technicaltest.domain.model.Price;
import com.inditex.technicaltest.infraestructure.repository.PricesRepository;
import com.inditex.technicaltest.infraestructure.repository.entity.BrandEntity;
import com.inditex.technicaltest.infraestructure.repository.entity.PriceEntity;
import com.inditex.technicaltest.infraestructure.repository.entity.ProductEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class PricesRepoTest {
    @Autowired
    private PricesRepo pricesRepo;
    @MockBean
    private PricesRepository pricesRepository;

    @Test
    void Given_RepositoryReturnEmpty_When_FindByProductIdAndBrandId_Then_ReturnEmpty(){
        when(pricesRepository.findByProductIdBrandIdAndApplicationDate(anyLong(), anyLong(), any(LocalDateTime.class))).thenReturn(new ArrayList<>());

        List<Price> actual = pricesRepo.findByProductIdBrandIdAndApplicationDate(1L, 1L, LocalDateTime.now());

        assertThat(actual).isEmpty();
    }

    @Test
    void Given_HappyPath_When_FindByProductIdAndBrandId_Then_Success(){
        PriceEntity priceEntity = getPriceEntity();
        Price expected = getPrice();

        when(pricesRepository.findByProductIdBrandIdAndApplicationDate(anyLong(), anyLong(), any(LocalDateTime.class))).thenReturn(List.of(priceEntity));

        Price actual = pricesRepo.findByProductIdBrandIdAndApplicationDate(1L, 1L, LocalDateTime.now()).stream().findFirst().orElse(null);

        assertThat(actual).isNotNull();
        assertEquals(expected, actual);

        verify(pricesRepository, times(1)).findByProductIdBrandIdAndApplicationDate(anyLong(), anyLong(), any(LocalDateTime.class));
    }

    private Price getPrice() {
        Price price = new Price();

        price.setId(1L);
        price.setProductId(1L);
        price.setBrandId(1L);
        price.setStartDate(LocalDateTime.of(2022, 1, 1, 12, 0, 0));
        price.setEndDate(LocalDateTime.of(2022, 12, 31, 12, 0, 0));
        price.setPriority(0);
        price.setPrice(35.50);
        price.setCurrency("EUR");

        return price;
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
