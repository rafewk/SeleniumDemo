package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.testeroprogramowania.utils.Helper;

public class CartPage {

    @FindBy(partialLinkText = "Proceed to checkout")
    private WebElement checkoutBtn;
//*********************** END OF WEB_ELEMENTS *********************************

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

//************************ METHODS: ********************************************

    public CheckoutPage openCheckoutPage() {
        Helper.waitToBeClickable(driver,checkoutBtn);
        checkoutBtn.click();
        return new CheckoutPage(driver);
    }
}
