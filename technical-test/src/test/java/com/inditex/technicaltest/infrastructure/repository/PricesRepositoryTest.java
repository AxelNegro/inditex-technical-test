package com.inditex.technicaltest.infrastructure.repository;

import com.inditex.technicaltest.infrastructure.repository.entity.BrandEntity;
import com.inditex.technicaltest.infrastructure.repository.entity.PriceEntity;
import com.inditex.technicaltest.infrastructure.repository.entity.ProductEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class PricesRepositoryTest {
    @Autowired
    private BrandsRepository brandsRepository;
    @Autowired
    private ProductsRepository productRepository;
    @Autowired
    private PricesRepository pricesRepository;

    @Test
    void Given_HappyPath_When_FindByProductIdBrandIdAndApplicationDate_Then_Success(){
        BrandEntity brandEntity = brandsRepository.save(getBrandEntity());
        ProductEntity productEntity = productRepository.save(getProductEntity());

        pricesRepository.save(getPriceEntity(productEntity, brandEntity));

        List<PriceEntity> prices = pricesRepository.findByProductIdBrandIdAndApplicationDate(productEntity.getId(), brandEntity.getId(), LocalDateTime.of(2022, 6, 15, 6, 0, 0));

        assertThat(prices).isNotEmpty();
    }

    private PriceEntity getPriceEntity(ProductEntity productEntity, BrandEntity brandEntity) {
        PriceEntity priceEntity = new PriceEntity();

        priceEntity.setId(1L);
        priceEntity.setProduct(productEntity);
        priceEntity.setBrand(brandEntity);
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
