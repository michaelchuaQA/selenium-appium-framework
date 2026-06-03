package com.qa.driver;

import com.qa.config.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MobileDriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static WebDriver initAndroidDriver() {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName(ConfigReader.get("mobile.device.name"))
                .setPlatformVersion(ConfigReader.get("mobile.platform.version"))
                .setApp(System.getProperty("user.dir") + "/" + ConfigReader.get("mobile.app.path"))
                .setAutomationName(ConfigReader.get("mobile.automation.name"))
                .setNewCommandTimeout(Duration.ofSeconds(60));

        try {
            AndroidDriver androidDriver = new AndroidDriver(
                    new URL(ConfigReader.get("appium.server.url")), options);
            driver.set(androidDriver);
            return androidDriver;
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Appium server URL", e);
        }
    }

    public static WebDriver initIOSDriver() {
        XCUITestOptions options = new XCUITestOptions()
                .setDeviceName(ConfigReader.get("mobile.device.name"))
                .setPlatformVersion(ConfigReader.get("mobile.platform.version"))
                .setApp(System.getProperty("user.dir") + "/" + ConfigReader.get("mobile.app.path"))
                .setNewCommandTimeout(Duration.ofSeconds(60));

        try {
            IOSDriver iosDriver = new IOSDriver(
                    new URL(ConfigReader.get("appium.server.url")), options);
            driver.set(iosDriver);
            return iosDriver;
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Appium server URL", e);
        }
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
