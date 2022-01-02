package pl.testeroprogramowania.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver(Browsers browser) {
        if(driver == null) {
            switch (browser) {
                case CHROME -> {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
                case FIREFOX -> {
                    WebDriverManager.firefoxdriver().setup();
                    driver =  new FirefoxDriver();
                }
                case EDGE -> {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }
            }
        }
        return driver;
    }
    public static void quitDriver(){
        driver.quit();
        driver = null;
    }
}
