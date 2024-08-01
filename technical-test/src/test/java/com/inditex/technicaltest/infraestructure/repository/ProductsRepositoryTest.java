package com.inditex.technicaltest.infraestructure.repository;

import com.inditex.technicaltest.infraestructure.repository.entity.ProductEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
public class ProductsRepositoryTest {
    @Autowired
    private ProductsRepository productsRepository;

    @Test
    void Given_HappyPath_When_FindById_Then_Success(){
        ProductEntity expected = productsRepository.save(getProductEntity());

        ProductEntity actual = productsRepository.findById(expected.getId()).orElse(null);

        assertThat(actual).isNotNull();
        assertEquals(expected, actual);
    }
    private ProductEntity getProductEntity() {
        return new ProductEntity(1L, "SHOES");
    }
}
