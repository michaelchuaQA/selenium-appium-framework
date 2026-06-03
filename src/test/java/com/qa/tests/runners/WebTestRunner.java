package com.qa.tests.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features/web",
        glue = {"com.qa.tests.steps.web", "com.qa.tests.hooks"},
        tags = "@web",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/web-report.html",
                "json:target/cucumber-reports/web-report.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)
public class WebTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
