package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenNewAccount extends Register {
    protected WebDriver driver;
    public static WebDriverWait wait;

    public OpenNewAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[text()='Open New Account']")
    private WebElement openNewAccountLink;

    @FindBy(id = "type")
    private WebElement typeOfAccountDropdown;

    @FindBy(id = "fromAccountId")
    private WebElement transferFromAccountDropdown;

    @FindBy(css = "input.button[value='Open New Account']")
    private WebElement openNewAccountButton;;

    // Test Case 1: Open CHECKING Account
    public void openCheckingAccount() throws InterruptedException {
        openNewAccountLink.click();
        openNewAccount("CHECKING");
    }

    // Test Case 2: Open SAVINGS Account
    public void openSavingsAccount() throws InterruptedException {
        openNewAccountLink.click();
        openNewAccount("SAVINGS");
    }

    private void openNewAccount(String accountType) {
        Select typeDropdown = new Select(typeOfAccountDropdown);
        typeDropdown.selectByVisibleText(accountType);

        Select fromAccountDropdown = new Select(transferFromAccountDropdown);
        fromAccountDropdown.selectByIndex(0);

        openNewAccountButton.click();
    }

}