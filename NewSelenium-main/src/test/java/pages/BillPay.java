package pages;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BillPay extends BaseTest {
    protected WebDriver driver;
    public static WebDriverWait wait;

    public BillPay(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Bill Pay']")
    private WebElement billPayLink;

    @FindBy(name = "payee.name")
    private WebElement payeeNameInput;

    @FindBy(name = "payee.address.street")
    private WebElement addressInput;

    @FindBy(name = "payee.address.city")
    private WebElement cityInput;

    @FindBy(name = "payee.address.state")
    private WebElement stateInput;

    @FindBy(name = "payee.address.zipCode")
    private WebElement zipCodeInput;

    @FindBy(name = "payee.phoneNumber")
    private WebElement phoneInput;

    @FindBy(name = "payee.accountNumber")
    private WebElement toAccountInput;

    @FindBy(name = "verifyAccount")
    private WebElement verifyToAccountInput;

    @FindBy(name = "amount")
    private WebElement amountInput;

    @FindBy(name = "fromAccountId")
    private WebElement fromAccountDropdown;

    @FindBy(css = "input.button[value='Send Payment']")
    private WebElement sendPaymentButton;

    // Test Case 1: Pay bill with Account Owner
    public void billPayfromAccountHolder(String payeeName, String address, String city, String state, String zipCode,
                        String phone, String toAccount, String amount) throws InterruptedException{

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //WebElement billPayLinkElement = wait.until(ExpectedConditions.elementToBeClickable(billPayLink));
        billPayLink.click();
        fillBillPayForm(payeeName, address, city, state, zipCode, phone, toAccount, amount);
        sendPayment();
    }

    // Test Case 1: Pay bill with Different Account, not from Owner
    public void billPayWithDifferentAccount(String payeeName, String address, String city, String state, String zipCode,
                                            String phone, String toAccount, String amount) throws InterruptedException{

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //WebElement billPayLinkElement = wait.until(ExpectedConditions.elementToBeClickable(billPayLink));
        billPayLink.click();
        fillBillPayForm(payeeName, address, city, state, zipCode, phone, toAccount, amount);
        sendPayment();
    }

    public void fillBillPayForm(String payeeName, String address, String city, String state, String zipCode,
                                String phone, String toAccount, String amount) {
        payeeNameInput.sendKeys(payeeName);
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
        stateInput.sendKeys(state);
        zipCodeInput.sendKeys(zipCode);
        phoneInput.sendKeys(phone);
        toAccountInput.sendKeys(toAccount);
        verifyToAccountInput.sendKeys(toAccount);
        amountInput.sendKeys(amount);

        Select fromAccountDropdownSelect = new Select(fromAccountDropdown);
        fromAccountDropdownSelect.selectByIndex(0);
    }

    public void sendPayment() {
        sendPaymentButton.click();
    }
}
