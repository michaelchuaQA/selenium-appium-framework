package com.qa.tests.hooks;

import com.qa.config.ConfigReader;
import com.qa.driver.DriverFactory;
import com.qa.utils.ScreenshotUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class WebHooks {

    @Before("@web")
    public void setUp() {
        DriverFactory.initDriver();
    }

    @After("@web")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtils.captureScreenshot(DriverFactory.getDriver(), scenario.getName());
        }
        DriverFactory.quitDriver();
    }
}
