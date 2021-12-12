package pl.testeroprogramowania.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationTest extends BaseTest {

    @Test
    public void registerUserTest() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("ddMMss");
        String email = format.format(date);

        WebElement dashboard = new HomePage(driver)
                .openMyAccountPage()
                .registerUserValidData("tester" + email + "@wp.pl", "123456tester!")
                .getDashboardLink();

        Assert.assertTrue(dashboard.isDisplayed());
        Assert.assertEquals(dashboard.getText(), "Dashboard");
    }

    @Test
    public void registerUserWithUsedEmailTest() {
        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .registerUserInvalidData("tester@wp.pl", "123456tester!")
                .getError();

        Assert.assertTrue(error.getText().contains(" An account is already registered with your email address."));
    }
}
