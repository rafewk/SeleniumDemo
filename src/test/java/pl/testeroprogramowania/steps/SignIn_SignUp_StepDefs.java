package pl.testeroprogramowania.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pl.testeroprogramowania.pages.HomePage;
import pl.testeroprogramowania.pages.LoggedUserPage;
import pl.testeroprogramowania.pages.MyAccountPage;
import pl.testeroprogramowania.utils.Browsers;
import pl.testeroprogramowania.utils.DriverFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SignIn_SignUp_StepDefs {

    private String email;
    private LoggedUserPage loggedUserPage;


    @Given("User with unique email")
    public void userWithUniqueEmail() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("ddMMss");
        String unique = format.format(date);
        email = "tester" + unique + "@wp.pl";
    }

    @When("User register itself")
    public void userRegisterItself() throws InterruptedException {
        loggedUserPage = new HomePage(DriverFactory.getDriver(Browsers.CHROME))
                .openMyAccountPage()
                .registerUserValidData(email, "123456tester!");
    }

    @Then("User is redirected to the logged user's page")
    public void userIsRedirectedToTheLoggedUserSPage() {
        WebElement dashboard = loggedUserPage.getDashboardLink();

        Assert.assertTrue(dashboard.isDisplayed());
        Assert.assertEquals(dashboard.getText(), "Dashboard");
    }

    @Then("Error message informing about already registered email appears")
    public void errorMessageInformingAboutAlreadyRegisteredEmailAppears() {
        WebElement error = new MyAccountPage(DriverFactory.getDriver(Browsers.CHROME)).getError();
        Assert.assertTrue(error.getText().contains(" An account is already registered with your email address."));
    }

    @Given("User is at My Account Page")
    public void userIsAtMyAccountPage() {
        new HomePage(DriverFactory.getDriver(Browsers.CHROME)).openMyAccountPage();
    }


    @When("User logs in with valid data {string},{string}")
    public void userLogsInWithValidData(String name, String password) {
        loggedUserPage = new HomePage(DriverFactory.getDriver(Browsers.CHROME))
                .openMyAccountPage().loginValidData(name,password);
    }

    @Given("User with email {string} already registered in database")
    public void userWithEmailAlreadyRegisteredInDatabase(String email) {
        this.email=email;
    }
}
