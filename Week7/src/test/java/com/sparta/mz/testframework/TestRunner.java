package com.sparta.mz.testframework;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.sparta.mz.testframework",
        plugin = {"pretty", "html:target/cucumber-reports"},
        publish = true
)

public class TestRunner {

}
