package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    @FindBy(name = "add-to-cart")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//div/a[@href='http://seleniumdemo.com/?page_id=5']")
    private WebElement viewCartBtn;
//*********************** END OF WEB_ELEMENTS *********************************

    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

//************************ METHODS: ********************************************

    public ProductPage addProductToCart() {
        addToCartBtn.click();
        return this;
    }

    public CartPage viewCartPage() {
        viewCartBtn.click();
        return new CartPage(driver);
    }
}
