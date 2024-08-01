package com.inditex.technicaltest.domain.port.in;

import com.inditex.technicaltest.common.exceptions.InditexException;
import com.inditex.technicaltest.domain.model.Price;
import com.inditex.technicaltest.domain.port.out.PricesRepo;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class PricesServiceTest {
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
        Price minorPriority = getPrice(0L, 0);
        Price majorPriority = getPrice(1L, 1);

        when(pricesRepo.findByProductIdBrandIdAndApplicationDate(anyLong(), anyLong(), any(LocalDateTime.class))).thenReturn(List.of(minorPriority, majorPriority));

        assertEquals(majorPriority, pricesService.getByProductIdBrandIdAndApplicationDate(1L, 1L, LocalDateTime.of(2022, 6, 15, 6, 0, 0)));

        verify(pricesRepo, times(1)).findByProductIdBrandIdAndApplicationDate(anyLong(), anyLong(), any(LocalDateTime.class));
    }

    @Test
    void Given_HappyPath_When_GetByProductIdBrandIdAndApplicationDate_Then_Success(){
        Price expected = getPrice(0L, 0);
        when(pricesRepo.findByProductIdBrandIdAndApplicationDate(anyLong(), anyLong(), any(LocalDateTime.class))).thenReturn(List.of(expected));

        assertEquals(expected, pricesService.getByProductIdBrandIdAndApplicationDate(1L, 1L, LocalDateTime.of(2022, 6, 15, 6, 0, 0)));

        verify(pricesRepo, times(1)).findByProductIdBrandIdAndApplicationDate(anyLong(), anyLong(), any(LocalDateTime.class));
    }

    private Price getPrice(Long id, int priority) {
        Price price = new Price();

        price.setId(id);
        price.setBrandId(1L);
        price.setProductId(1L);
        price.setStartDate(LocalDateTime.of(2022, 1, 1, 12, 0, 0));
        price.setEndDate(LocalDateTime.of(2022, 12, 31, 12, 0, 0));
        price.setPrice(35.50);
        price.setCurrency("EUR");
        price.setPriority(priority);

        return price;
    }
}
