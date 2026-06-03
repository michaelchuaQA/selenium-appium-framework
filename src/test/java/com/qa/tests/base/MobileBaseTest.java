package com.qa.tests.base;

import com.qa.driver.MobileDriverFactory;
import com.qa.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class MobileBaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = MobileDriverFactory.initAndroidDriver();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenshotUtils.captureScreenshot(driver, result.getName());
        }
        MobileDriverFactory.quitDriver();
    }
}
