package pages;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RequestLoan extends BaseTest {
    public RequestLoan(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Request Loan']")
    private WebElement requestLoanLink;

    @FindBy(id = "amount")
    private WebElement amountInput;

    @FindBy(id = "downPayment")
    private WebElement downPaymentInput;

    @FindBy(id = "fromAccountId")
    private WebElement fromAccountDropdown;

    @FindBy(css = "input.button[value='Apply Now']")
    private WebElement applyNowButton;
    @FindBy(xpath = "//p[contains(@class, 'error') and contains(text(), 'An internal error has occurred and has been logged.')]")
    private WebElement requestLoanError;

    // Test Case 1: Successful Loan Request
    public void requestLoan(String amount, String downPayment) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement requestLoanLinkElement = wait.until(ExpectedConditions.elementToBeClickable(requestLoanLink));
        requestLoanLinkElement.click();

        fillLoanRequestForm(amount, downPayment);
        applyNow();
    }

    // Test Case 2: Requesting Loan without filling details
    public void requestLoanForEmptyField() {
        amountInput.sendKeys("");
        downPaymentInput.sendKeys("");
        boolean isErrorDisplayed = isElementPresent(requestLoanError);
        Assert.assertFalse(isErrorDisplayed, "Error message is not displayed for empty fields.");
    }

    private boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            return false;
        }
    }


    private void fillLoanRequestForm(String amount, String downPayment) {
        amountInput.sendKeys(amount);
        downPaymentInput.sendKeys(downPayment);

        Select fromAccountDropdownSelect = new Select(fromAccountDropdown);
        fromAccountDropdownSelect.selectByIndex(0);
    }

    private void applyNow() {
        applyNowButton.click();
    }
}
