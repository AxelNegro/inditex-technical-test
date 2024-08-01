package com.inditex.technicaltest.infrastructure.controller;

import com.inditex.technicaltest.common.BaseTestAnnotation;
import com.inditex.technicaltest.domain.model.PriceModel;
import com.inditex.technicaltest.domain.port.in.PricesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@BaseTestAnnotation
@WebAppConfiguration
class BrandsControllerTest {
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @MockBean
    private PricesService pricesService;

    @BeforeEach
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    void Given_HappyPath_When_GetBrandsBrandIdProductsProductIdPrices_Then_Success() throws Exception {
        when(pricesService.getByProductIdBrandIdAndApplicationDate(anyLong(), anyLong(), any(LocalDateTime.class))).thenReturn(getPrice());

        mvc.perform(MockMvcRequestBuilders.get("/brands/1/products/35455/prices?application_date=2020-06-15T21:00:00")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }


    private PriceModel getPrice() {
        PriceModel priceModel = new PriceModel();

        priceModel.setId(1L);
        priceModel.setBrandId(1L);
        priceModel.setProductId(1L);
        priceModel.setStartDate(LocalDateTime.of(2022, 1, 1, 12, 0, 0));
        priceModel.setEndDate(LocalDateTime.of(2022, 12, 31, 12, 0, 0));
        priceModel.setPrice(35.50);
        priceModel.setCurrency("EUR");
        priceModel.setPriority(1);

        return priceModel;
    }
}
