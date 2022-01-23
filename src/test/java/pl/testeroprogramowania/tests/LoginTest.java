package pl.testeroprogramowania.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        WebElement dashboard = new HomePage(driver)
                .openMyAccountPage()
                .loginValidData("tester", "123456tester!")
                .getDashboardLink();

        Assert.assertTrue(dashboard.getText().contains("Dashboard"));
    }

    //@Test
    public void loginWrongDataTest() {
        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .loginInvalidData("tes", "123456tester!")
                .getError();

        Assert.assertTrue(error.getText().contains(": Incorrect username or password."));
    }
}
