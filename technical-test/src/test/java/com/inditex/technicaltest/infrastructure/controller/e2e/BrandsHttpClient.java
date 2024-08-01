package com.inditex.technicaltest.infrastructure.controller.e2e;

import com.inditex.technicaltest.infrastructure.controller.dto.PriceDto;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class BrandsHttpClient {

    @LocalServerPort
    private int port;
    private final RestTemplate restTemplate = new RestTemplate();

    private String brandsEndpoint(String brandId, String productId, String applicationDate) {
        String brandsEndpoint = "brands/%s/products/%s/prices?application_date=%s";
        String serverUrl = "http://localhost:%s/inditex/api/%s";
        return String.format(serverUrl, port, String.format(brandsEndpoint, brandId, productId, applicationDate));
    }
    public PriceDto getPrice(String brandId, String productId, String applicationDate) {
        return restTemplate.getForEntity(brandsEndpoint(brandId, productId, applicationDate), PriceDto.class).getBody();
    }

}
