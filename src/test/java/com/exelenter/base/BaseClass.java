package com.exelenter.base;

import com.exelenter.utils.CommonMethods;
import com.exelenter.utils.ConfigsReader;
import com.exelenter.utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

// NOTE: THIS CLASS IS USED TO LAUNCH AND QUIT THE BROWSER

public class BaseClass extends CommonMethods {
    public static WebDriver driver;

    public static void setUp() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        ConfigsReader.loadProperties(Constants.CONFIGURATION_FILEPATH); // Replaced hard-coded filePath with Constants
        String headless = ConfigsReader.getProperties("headless");

        switch (ConfigsReader.getProperties("browser").toLowerCase()) {
            case "chrome" -> {
                //System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
                WebDriverManager.chromedriver().setup(); // This line will replace local drivers
                if (headless.equalsIgnoreCase("true")) {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");         // Run in Headless mode
                    driver = new ChromeDriver(options);
                } else {
                    driver = new ChromeDriver();
                }
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                if (headless.equalsIgnoreCase("true")) {
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments("--headless");         // Run in Headless mode
                    driver = new FirefoxDriver(options);
                } else {
                    driver = new FirefoxDriver();
                }
            }
            default -> throw new RuntimeException("Browser is not supported");
        }

        driver.get(ConfigsReader.getProperties("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
        initialize();
    }

    public static void tearDown() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        if (driver != null) {     // This line is optional. We only use it to prevent NullPointerException.
            driver.quit();
        }
    }

}
