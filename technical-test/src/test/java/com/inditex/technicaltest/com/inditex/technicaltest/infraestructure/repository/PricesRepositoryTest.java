package com.inditex.technicaltest.com.inditex.technicaltest.infraestructure.repository;

import com.inditex.technicaltest.infraestructure.repository.PricesRepository;
import com.inditex.technicaltest.infraestructure.repository.entity.PriceEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PricesRepositoryTest {
    @Autowired
    private PricesRepository pricesRepository;

    @Test
    void Given_HappyPath_When_FindByProductIdAndBrandId_Then_Success(){
        List<PriceEntity> prices = pricesRepository.findByProductIdAndBrandId(35455L, 1L);

        assertThat(prices).isNotEmpty();
    }
}
