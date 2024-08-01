package com.inditex.technicaltest.domain.port.in;

import com.inditex.technicaltest.common.BaseTestAnnotation;
import com.inditex.technicaltest.common.exceptions.InditexException;
import com.inditex.technicaltest.domain.model.PriceModel;
import com.inditex.technicaltest.domain.port.out.PricesRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@BaseTestAnnotation
class PricesServiceTest {
    @Autowired
    private PricesService pricesService;
    @MockBean
    private PricesRepo pricesRepo;

    @Test
    void Given_EmptyPrices_When_GetByProductIdBrandIdAndApplicationDate_Then_ThrowException(){
        when(pricesRepo.findByProductIdBrandIdAndApplicationDate(anyLong(), anyLong(), any(LocalDateTime.class))).thenReturn(new ArrayList<>());

        assertThrows(InditexException.class, () -> pricesService.getByProductIdBrandIdAndApplicationDate(1L, 1L, LocalDateTime.of(2022, 6, 15, 6, 0, 0)));

        verify(pricesRepo, times(1)).findByProductIdBrandIdAndApplicationDate(anyLong(), anyLong(), any(LocalDateTime.class));
    }

    @Test
    void Given_PricesCollision_When_GetByProductIdBrandIdAndApplicationDate_Then_GetMajorPriority(){
        PriceModel minorPriority = getPrice(0L, 0);
        PriceModel majorPriority = getPrice(1L, 1);

        when(pricesRepo.findByProductIdBrandIdAndApplicationDate(anyLong(), anyLong(), any(LocalDateTime.class))).thenReturn(List.of(minorPriority, majorPriority));

        assertEquals(majorPriority, pricesService.getByProductIdBrandIdAndApplicationDate(1L, 1L, LocalDateTime.of(2022, 6, 15, 6, 0, 0)));

        verify(pricesRepo, times(1)).findByProductIdBrandIdAndApplicationDate(anyLong(), anyLong(), any(LocalDateTime.class));
    }

    @Test
    void Given_HappyPath_When_GetByProductIdBrandIdAndApplicationDate_Then_Success(){
        PriceModel expected = getPrice(0L, 0);
        when(pricesRepo.findByProductIdBrandIdAndApplicationDate(anyLong(), anyLong(), any(LocalDateTime.class))).thenReturn(List.of(expected));

        assertEquals(expected, pricesService.getByProductIdBrandIdAndApplicationDate(1L, 1L, LocalDateTime.of(2022, 6, 15, 6, 0, 0)));

        verify(pricesRepo, times(1)).findByProductIdBrandIdAndApplicationDate(anyLong(), anyLong(), any(LocalDateTime.class));
    }

    private PriceModel getPrice(Long id, int priority) {
        PriceModel priceModel = new PriceModel();

        priceModel.setId(id);
        priceModel.setBrandId(1L);
        priceModel.setProductId(1L);
        priceModel.setStartDate(LocalDateTime.of(2022, 1, 1, 12, 0, 0));
        priceModel.setEndDate(LocalDateTime.of(2022, 12, 31, 12, 0, 0));
        priceModel.setPrice(35.50);
        priceModel.setCurrency("EUR");
        priceModel.setPriority(priority);

        return priceModel;
    }
}
