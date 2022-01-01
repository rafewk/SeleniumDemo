package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.testeroprogramowania.utils.Helper;

public class MyAccountPage {

    @FindBy(id = "reg_email")
    private WebElement emailRegInput;

    @FindBy(id = "reg_password")
    private WebElement passwordRegInput;

    @FindBy(name = "register")
    private WebElement registerBtn;

    @FindBy(xpath = "//ul[@role='alert']/li")
    private WebElement Error;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(name = "login")
    private WebElement loginBtn;
//*********************** END OF WEB_ELEMENTS *********************************

    private final WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
//************************ METHODS: ********************************************

    private void registerUser(String email, String password) {
        emailRegInput.sendKeys(email);
        passwordRegInput.sendKeys(password);
        Helper.waitToBeClickable(driver,registerBtn);
        registerBtn.click();
    }

    public LoggedUserPage registerUserValidData(String email, String password) {
        registerUser(email, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage registerUserInvalidData(String email, String password) {
        registerUser(email, password);
        return this;
    }

    public WebElement getError() {
        return Error;
    }

    private void logIn(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public LoggedUserPage loginValidData(String username, String password) {
        logIn(username, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage loginInvalidData(String username, String password) {
        logIn(username, password);
        return this;
    }
}
