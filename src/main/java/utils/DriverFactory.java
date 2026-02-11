package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> ThreadDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return ThreadDriver.get();
    }

    public static void initDriver() {

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.managed_default_content_settings.ads", 2);

        ChromeOptions options = new ChromeOptions();

        options.addExtensions(new File("src/test/resources/uBlockOriginLite.crx"));
        options.setExperimentalOption("prefs", prefs);

        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-features=InterestFeedContentSuggestions");

        WebDriver driver = new ChromeDriver(options);
        ThreadDriver.set(driver);
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void quitDriver() {
        if (getDriver() != null) {

            getDriver().quit();

            ThreadDriver.remove();
        }
    }
}