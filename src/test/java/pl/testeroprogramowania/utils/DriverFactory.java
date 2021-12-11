package pl.testeroprogramowania.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver getDriver(Browsers browser) {
        switch (browser) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
            case EDGE -> {
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            }
        }
        return null;
    }
}
