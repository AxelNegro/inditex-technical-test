package com.inditex.technicaltest.infrastructure.controller.e2e;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber.json"},
        features = "classpath:features",
        extraGlue = "com.inditex.technicaltest.infrastructure.controller.e2e"
)
public class CucumberRunnerTest {
}
