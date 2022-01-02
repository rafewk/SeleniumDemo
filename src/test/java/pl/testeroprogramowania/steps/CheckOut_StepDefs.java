package pl.testeroprogramowania.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pl.testeroprogramowania.models.Customer;
import pl.testeroprogramowania.pages.*;
import pl.testeroprogramowania.utils.Browsers;
import pl.testeroprogramowania.utils.DriverFactory;

import java.time.Duration;

public class CheckOut_StepDefs {

    private Customer customer;
    private CartPage cartPage;
    private OrderDetailsPage orderDetailsPage;
    private ProductsListPage productsListPage;

    @Given("User is at Shop Page")
    public void userIsAtShopPage() {
        productsListPage = new HomePage(DriverFactory.getDriver(Browsers.CHROME))
                .openProductsListPage();
    }

    @When("User adds a product to the cart")
    public void userAddsAProductToTheCart() {
        cartPage = productsListPage.openProductPage("GIT basics")
                .addProductToCart()
                .viewCartPage();
    }

    @And("Fills shipping information form")
    public void fillsShippingInformationForm() {
        customer = new Customer();
        orderDetailsPage = cartPage.openCheckoutPage().fillFormAndPlaceOrder(customer,"Hello 2022!");
    }

    @Then("User is redirected to the Order Details Page")
    public void userIsRedirectedToTheOrderDetailsPage() {
        Assert.assertTrue(orderDetailsPage.getOrderReceivedParagraph().getText().contains("Your order has been received."));
        Assert.assertEquals(orderDetailsPage.getOrderedProductName().getText(), "GIT basics × 1");
    }
}
