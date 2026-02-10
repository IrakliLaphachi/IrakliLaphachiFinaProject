package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;

public class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        installVignetteBypass();
    }
    private void installVignetteBypass() {

        if (driver == null) return;

        ((JavascriptExecutor) driver).executeScript("""
        
        if (!window.__vignetteBypassInstalled) {

            window.__vignetteBypassInstalled = true;

            setInterval(() => {

                if (window.location.href.includes('#google_vignette')) {

                    console.log('Vignette detected. Reloading...');

                    const cleanUrl = window.location.href
                        .replace('#google_vignette', '');

                    window.location.replace(cleanUrl);
                }

            }, 500);
        }
    """);
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

}