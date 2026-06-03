package com.qa.tests.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/mobile",
        glue = {"com.qa.tests.steps.mobile", "com.qa.tests.hooks"},
        tags = "@mobile",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/mobile-report.html",
                "json:target/cucumber-reports/mobile-report.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)
public class MobileTestRunner extends AbstractTestNGCucumberTests {
}
