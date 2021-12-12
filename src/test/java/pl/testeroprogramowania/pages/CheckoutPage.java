package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.testeroprogramowania.models.Customer;
import pl.testeroprogramowania.utils.Helper;

import java.time.Duration;

public class CheckoutPage {

    @FindBy(id = "billing_first_name")
    private WebElement firstNameInput;

    @FindBy(id = "billing_last_name")
    private WebElement lastNameInput;

    @FindBy(id = "billing_address_1")
    private WebElement houseAndStreetInput;

    @FindBy(id = "billing_postcode")
    private WebElement postcodeInput;

    @FindBy(id = "billing_city")
    private WebElement cityInput;

    @FindBy(id = "billing_phone")
    private WebElement phoneNumberInput;

    @FindBy(id = "billing_email")
    private WebElement emailInput;

    @FindBy(id = "billing_company")
    private WebElement companyName;

    @FindBy(id = "billing_country")
    private WebElement countriesList;

    @FindBy(id = "order_comments")
    private WebElement orderCommentInput;

    @FindBy(id = "place_order")
    private WebElement placeOrderBtn;

//*********************** END OF WEB_ELEMENTS *********************************

    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

//************************ METHODS: *******************************************

    public OrderDetailsPage fillFormAndPlaceOrder(Customer customer, String comment) {
        firstNameInput.sendKeys(customer.getFirstName());
        lastNameInput.sendKeys(customer.getLastName());
        companyName.sendKeys(customer.getCompanyName());
        houseAndStreetInput.sendKeys(customer.getHouseAndStreet());
        postcodeInput.sendKeys(customer.getPostCode());
        cityInput.sendKeys(customer.getCity());
        phoneNumberInput.sendKeys(customer.getPhoneNumber());
        emailInput.sendKeys(customer.getEmail());

        Select countrySelect = new Select(countriesList);
        countrySelect.selectByVisibleText(customer.getCountry());

        orderCommentInput.sendKeys(comment);
        Helper.waitToBeClickable(driver,placeOrderBtn);
        placeOrderBtn.click();

        return new OrderDetailsPage(driver);
    }
}
