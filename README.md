# Selenium + Appium Test Automation Framework

A comprehensive test automation framework for **web** and **mobile** testing using Selenium, Appium, and TestNG with the Page Object Model design pattern.

## Tech Stack

| Component | Technology |
|-----------|------------|
| Language | Java 17 |
| Web Automation | Selenium 4 |
| Mobile Automation | Appium 9 (UiAutomator2 / XCUITest) |
| Test Framework | TestNG |
| Build Tool | Maven |
| Reporting | Allure Reports |
| CI/CD | GitHub Actions |
| Driver Management | WebDriverManager |

## Project Structure

```
src/
├── main/java/com/qa/
│   ├── base/             # BasePage with common actions
│   ├── config/           # Configuration reader
│   ├── driver/           # Web & Mobile driver factories
│   ├── pages/
│   │   ├── web/          # Web page objects (SauceDemo)
│   │   └── mobile/       # Mobile page objects
│   └── utils/            # Wait & screenshot utilities
└── test/
    ├── java/com/qa/tests/
    │   ├── base/         # Base test classes
    │   ├── web/          # Web test cases
    │   └── mobile/       # Mobile test cases
    └── resources/
        ├── config.properties
        ├── testng-web.xml
        └── testng-mobile.xml
```

## Design Patterns

- **Page Object Model (POM)** — each page/screen is a class with locators and actions
- **Factory Pattern** — DriverFactory and MobileDriverFactory manage driver lifecycle
- **Thread-safe drivers** — ThreadLocal ensures parallel test execution
- **Base Page abstraction** — common interactions (click, type, wait) in one place

## Prerequisites

### Web Testing
- Java 17+
- Maven 3.8+
- Chrome browser

### Mobile Testing
- Appium Server 2.x (`npm install -g appium`)
- Android SDK / Xcode
- Android Emulator or iOS Simulator
- Appium UiAutomator2 driver (`appium driver install uiautomator2`)

## Setup & Run

### Clone the repository
```bash
git clone https://github.com/michaelchuaQA/selenium-appium-framework.git
cd selenium-appium-framework
```

### Run Web Tests
```bash
mvn clean test -DsuiteXmlFile=src/test/resources/testng-web.xml
```

### Run Mobile Tests
Start Appium server first:
```bash
appium
```

Then run:
```bash
mvn clean test -DsuiteXmlFile=src/test/resources/testng-mobile.xml
```

### Generate Allure Report
```bash
mvn allure:serve
```

## Test Scenarios

### Web (SauceDemo)
| Test | Description |
|------|-------------|
| Valid Login | Login with standard_user credentials |
| Locked Out User | Verify error for locked account |
| Invalid Credentials | Verify error for wrong username/password |
| Empty Username | Verify required field validation |
| Empty Password | Verify required field validation |
| Products Displayed | Verify 6 products load after login |
| Add to Cart | Verify cart badge updates |

### Mobile (SauceLabs Sample App)
| Test | Description |
|------|-------------|
| Valid Login | Login and verify home screen |
| Invalid Login | Verify error message |
| Logout | Verify logout flow |

## CI/CD

GitHub Actions runs web tests automatically on every push and pull request. See `.github/workflows/web-tests.yml`.

The pipeline:
1. Sets up JDK 17
2. Caches Maven dependencies
3. Installs Chrome
4. Runs the web test suite
5. Generates and uploads Allure report as artifact

## Author

**Michael Chua** — QA Automation Engineer | [GitHub](https://github.com/michaelchuaQA)
