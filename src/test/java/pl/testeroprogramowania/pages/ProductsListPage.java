package pl.testeroprogramowania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductsListPage {


//*********************** END OF WEB_ELEMENTS *********************************

    private WebDriver driver;

    public ProductsListPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

//************************ METHODS: ********************************************

    public ProductPage openProductPage(String productTitle){
        driver.findElement(By.xpath("//h2[text()='"+ productTitle +"']")).click();
        return new ProductPage(driver);
    }
}
