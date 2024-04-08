package base;

import config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    public static WebDriverWait wait;

    public BaseTest(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BaseTest() {
    }

    @BeforeClass
    public void setUp() {
        Config config = new Config("chrome", "https://parabank.parasoft.com");
        initializeDriver(config);
        driver.get(config.getBaseUrl());
        driver.manage().window().maximize();
    }

    public WebDriver initializeDriver(Config config) {
        switch (config.getBrowser().toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--window-size=1920x1080");
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions);
                wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                break;


            default:
                throw new IllegalArgumentException("Unsupported browser: " + config.getBrowser());

        }
        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}

