package pl.testeroprogramowania;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pl.testeroprogramowania.pages.HomePage;
import pl.testeroprogramowania.pages.LoggedUserPage;
import pl.testeroprogramowania.pages.MyAccountPage;
import pl.testeroprogramowania.utils.Browsers;
import pl.testeroprogramowania.utils.DriverFactory;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class StepDefs {

    private WebDriver driver;
    private String email;

    @Before
    public void setUp(){
        driver = DriverFactory.getDriver(Browsers.CHROME);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://seleniumdemo.com/");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("User with unique email")
    public void userWithUniqueEmail() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("ddMMss");
        String unique = format.format(date);
        email = "tester" + unique + "@wp.pl";
    }

    @When("User register itself")
    public void userRegisterItself() {
        new HomePage(driver)
                .openMyAccountPage()
                .registerUserValidData(email, "123456tester!");
    }

    @Then("User is redirected to the logged user's page")
    public void userIsRedirectedToTheLoggedUserSPage() {

        WebElement dashboard = new LoggedUserPage(driver).getDashboardLink();

        Assert.assertTrue(dashboard.isDisplayed());
        Assert.assertEquals(dashboard.getText(), "Dashboard");
    }

    @Given("User with email already registered in database")
    public void userWithEmailAlreadyRegisteredInDatabase() {
        email = "1tester@wp.pl";
    }

    @Then("Error message informing about already registered email appears")
    public void errorMessageInformingAboutAlreadyRegisteredEmailAppears() {
        WebElement error = new MyAccountPage(driver).getError();
        Assert.assertTrue(error.getText().contains(" An account is already registered with your email address."));
    }

    @Given("User is at My Account Page")
    public void userIsAtMyAccountPage() {
        new HomePage(driver).openMyAccountPage();
    }

    @When("User logs in with valid data")
    public void userLogsInWithValidData() {
        new MyAccountPage(driver).loginValidData("tester","123456tester!");
    }
}
