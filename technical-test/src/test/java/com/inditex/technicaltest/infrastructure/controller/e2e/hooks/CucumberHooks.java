package com.inditex.technicaltest.infrastructure.controller.e2e.hooks;

import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
public class CucumberHooks {
    private static boolean isDatabaseInitialized = false;
    private final JdbcTemplate jdbcTemplate;
    private final ResourceLoader resourceLoader;

    @Autowired
    public CucumberHooks(JdbcTemplate jdbcTemplate, ResourceLoader resourceLoader) {
        this.jdbcTemplate = jdbcTemplate;
        this.resourceLoader = resourceLoader;
    }

    @Before
    public void beforeAllTests() {
        if (!isDatabaseInitialized) {
            try {
                Resource resource = resourceLoader.getResource("classpath:init.sql");
                Path sql = resource.getFile().toPath();

                jdbcTemplate.execute(new String(Files.readAllBytes(sql)));
                isDatabaseInitialized = true;
            }
            catch (Exception e){
                log.error(e.getMessage());
            }
        }
    }
}
