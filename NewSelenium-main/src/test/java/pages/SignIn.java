package pages;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignIn extends BaseTest {

    protected WebDriver driver;
    public static WebDriverWait wait;
    @FindBy(name = "username")
    private WebElement usernamelocator;

    @FindBy(name = "password")
    private WebElement passwordlocator;

    @FindBy(css = "input.button[value='Log In']")
    private WebElement loginButton;


    public SignIn(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void signInUser(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    private void enterUsername(String username) {
        usernamelocator.sendKeys(username);
    }

    private void enterPassword(String password) {
        passwordlocator.sendKeys(password);
    }

    private void clickLoginButton() {
        loginButton.click();
    }
}
