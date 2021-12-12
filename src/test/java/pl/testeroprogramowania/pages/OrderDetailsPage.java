package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderDetailsPage {

    @FindBy(xpath = "//div//p[text()='Thank you. Your order has been received.']")
    private WebElement orderReceivedParagraph;

    @FindBy(xpath = "//td[contains(@class, 'product-name')]")
    private WebElement orderedProductName;

//*********************** END OF WEB_ELEMENTS *********************************

    private WebDriver driver;

    public OrderDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

//************************ METHODS: *******************************************

    public WebElement getOrderReceivedParagraph() {
        return orderReceivedParagraph;
    }

    public WebElement getOrderedProductName() {
        return orderedProductName;
    }
}
