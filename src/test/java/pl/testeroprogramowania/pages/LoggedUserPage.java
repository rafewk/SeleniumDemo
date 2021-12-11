package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedUserPage {

    @FindBy(xpath = "//*[text()='Dashboard']")
    private WebElement dashboardLink;
//*********************** END OF WEB_ELEMENTS *********************************

    private final WebDriver driver;

    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

//************************ METHODS: ********************************************

    public WebElement getDashboardLink() {
        return dashboardLink;
    }
}
