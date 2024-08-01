package com.inditex.technicaltest.infrastructure.controller;

import com.inditex.technicaltest.common.BaseTestAnnotation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.inditex.technicaltest.common.enums.InditexExceptionsEnum.ERROR_701_EMPTY_PRICES;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@BaseTestAnnotation
@WebAppConfiguration
@Sql("/init.sql")
class BrandsControllerIntegrationTest {
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    void Given_HappyPath_When_GetProductPrices_Then_Success() throws Exception {
        // Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
        mvc.perform(MockMvcRequestBuilders.get("/brands/1/products/35455/prices?application_date=2020-06-14T10:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
        // Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
        mvc.perform(MockMvcRequestBuilders.get("/brands/1/products/35455/prices?application_date=2020-06-14T16:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2));
        // Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
        mvc.perform(MockMvcRequestBuilders.get("/brands/1/products/35455/prices?application_date=2020-06-14T21:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
        // Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
        mvc.perform(MockMvcRequestBuilders.get("/brands/1/products/35455/prices?application_date=2020-06-15T10:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(3));
        // Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
        mvc.perform(MockMvcRequestBuilders.get("/brands/1/products/35455/prices?application_date=2020-06-16T21:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(4));
        // Test 6: Non existent price
        mvc.perform(MockMvcRequestBuilders.get("/brands/1/products/35455/prices?application_date=2022-06-16T21:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value(ERROR_701_EMPTY_PRICES.getMessageDto().getCode()));
    }
}
