package com.qa.tests.hooks;

import com.qa.driver.MobileDriverFactory;
import com.qa.utils.ScreenshotUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MobileHooks {

    @Before("@mobile")
    public void setUp() {
        MobileDriverFactory.initAndroidDriver();
    }

    @After("@mobile")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtils.captureScreenshot(MobileDriverFactory.getDriver(), scenario.getName());
        }
        MobileDriverFactory.quitDriver();
    }
}
