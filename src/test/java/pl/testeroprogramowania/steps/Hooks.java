package pl.testeroprogramowania.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pl.testeroprogramowania.utils.Browsers;
import pl.testeroprogramowania.utils.DriverFactory;

import java.time.Duration;

public class Hooks {

    @Before
    public void setUp(){
        DriverFactory.getDriver(Browsers.CHROME).manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DriverFactory.getDriver(Browsers.CHROME).manage().window().maximize();
        DriverFactory.getDriver(Browsers.CHROME).get("http://seleniumdemo.com/");
    }

    /*@After
    public void tearDown(){
        DriverFactory.quitDriver();
    }*/
}
