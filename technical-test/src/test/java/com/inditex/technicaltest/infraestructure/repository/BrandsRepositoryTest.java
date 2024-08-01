package com.inditex.technicaltest.infraestructure.repository;

import com.inditex.technicaltest.infraestructure.repository.entity.BrandEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
public class BrandsRepositoryTest {
    @Autowired
    private BrandsRepository brandsRepository;

    @Test
    void Given_HappyPath_When_FindById_Then_Success(){
        BrandEntity expected = brandsRepository.save(getBrandEntity());

        BrandEntity actual = brandsRepository.findById(expected.getId()).orElse(null);

        assertThat(actual).isNotNull();
        assertEquals(expected, actual);
    }
    private BrandEntity getBrandEntity() {
        return new BrandEntity(1L, "ZARA");
    }
}
