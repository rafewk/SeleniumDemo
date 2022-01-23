package pl.testeroprogramowania.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.models.Customer;
import pl.testeroprogramowania.pages.HomePage;
import pl.testeroprogramowania.pages.OrderDetailsPage;

import java.time.Duration;

public class CheckOutTest extends BaseTest {

    @Test
    public void checkOut() {
        Customer customer = new Customer();

        OrderDetailsPage orderDetailsPage = new HomePage(driver)
                .openProductsListPage()
                .openProductPage("GIT basics")
                .addProductToCart()
                .viewCartPage()
                .openCheckoutPage()
                .fillFormAndPlaceOrder(customer, "It must arrive before Christmas, please.");

        Assert.assertTrue(orderDetailsPage.getOrderReceivedParagraph().getText().contains("Your order has been received."));
        Assert.assertEquals(orderDetailsPage.getOrderedProductName().getText(), "GIT basics × 1");
    }
}
