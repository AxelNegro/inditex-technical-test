package com.inditex.technicaltest.infrastructure.controller.e2e.steps;

import com.inditex.technicaltest.TechnicalTestApplication;
import com.inditex.technicaltest.infrastructure.controller.dto.PriceDto;
import com.inditex.technicaltest.infrastructure.controller.e2e.CucumberSpringConfiguration;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

@CucumberContextConfiguration
public class BrandsControllerSteps extends CucumberSpringConfiguration {
    @Then("I should be able to get price by product (.*) brand (.*) and application date (.*) and be price id (.*)$")
    public void i_should_be_able_to_get_price(String productId, String brandId, String applicationDate, String expectedPriceId) {
        assertEquals(expectedPriceId, getPrice(brandId, productId, applicationDate).getBody().getId().toString());
    }

    @Then("I should be get bad request when getting price by product (.*) brand (.*) and application date (.*)$")
    public void i_should_be_get_bad_request(String productId, String brandId, String applicationDate) {
        assertEquals(HttpStatusCode.valueOf(400), getPrice(brandId, productId, applicationDate).getStatusCode());
    }

    public ResponseEntity<PriceDto> getPrice(String brandId, String productId, String applicationDate) {
        String brandsEndpoint = String.format("/brands/%s/products/%s/prices?application_date=%s", brandId, productId, applicationDate);

        return testRestTemplate.getForEntity(brandsEndpoint, PriceDto.class);
    }
}
