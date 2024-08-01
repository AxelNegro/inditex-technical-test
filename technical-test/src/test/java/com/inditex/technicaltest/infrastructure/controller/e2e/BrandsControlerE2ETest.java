package com.inditex.technicaltest.infrastructure.controller.e2e;

import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BrandsControlerE2ETest {
    @Autowired
    private BrandsHttpClient brandsHttpClient;

    @Then("I should be able to get price by product (.*) brand (.*) and application date (.*) and be price id (.*)$")
    public void i_should_be_able_to_get_price(String productId, String brandId, String applicationDate, String expectedPriceId) {
        assertEquals(expectedPriceId, brandsHttpClient.getPrice(brandId, productId, applicationDate).getId().toString());
    }

    @Then("I should be able to get price by product (.*) brand (.*) and application date (.*)$")
    public void i_should_be_able_to_get_price(String productId, String brandId, String applicationDate) {
        assertThrows(HttpClientErrorException.BadRequest.class, () -> brandsHttpClient.getPrice(brandId, productId, applicationDate));
    }
}
