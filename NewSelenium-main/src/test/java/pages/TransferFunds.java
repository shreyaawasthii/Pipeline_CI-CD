package pages;

import base.BaseTest;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransferFunds extends BaseTest {
    protected WebDriver driver;
    public static WebDriverWait wait;

    public TransferFunds(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Transfer Funds']")
    private WebElement transferFundsLink;

    @FindBy(id = "amount")
    private WebElement amountInput;

    @FindBy(id = "fromAccountId")
    private WebElement fromAccountDropdown;

    @FindBy(id = "toAccountId")
    private WebElement toAccountDropdown;

    @FindBy(css = "input.button[value='Transfer']")
    private WebElement transferButton;

    @FindBy(xpath ="//select[@id='toAccountId']/option[@value='undefined']")
    private WebElement undefinedOption;


    // Test Case 1: Successful fund transfer
    public void transferFunds(String amount) throws InterruptedException {
        transferFundsLink.click();

        amountInput.sendKeys(amount);

        Select fromAccountDropdownSelect = new Select(fromAccountDropdown);
        WebElement selectedFromAccountOption = fromAccountDropdownSelect.getOptions().get(0);
        String fromAccount = selectedFromAccountOption.getAttribute("value");

        Select toAccountDropdownSelect = new Select(toAccountDropdown);
        WebElement selectedToAccountOption = toAccountDropdownSelect.getOptions().get(0);
        String toAccount = selectedToAccountOption.getAttribute("value");

        transferButton.click();

        writeTransactions(fromAccount, toAccount, amount);

    }


    // Test Case 2: Fund transfer with undefined Account Option
    public void transferUndefinedFunds(String amount) throws InterruptedException {
        transferFundsLink.click();

        amountInput.sendKeys(amount);

        WebElement fromAccountDropdown = driver.findElement(By.id("fromAccountId"));
        Select fromAccountDropdownSelect = new Select(fromAccountDropdown);
        fromAccountDropdownSelect.selectByValue("undefined");

        WebElement toAccountDropdown = driver.findElement(By.id("toAccountId"));
        Select toAccountDropdownSelect = new Select(toAccountDropdown);
        toAccountDropdownSelect.selectByValue("undefined");

        transferButton.click();
    }


    private void writeTransactions(String fromAccount, String toAccount, String amount) {
        List<String> transactionData = new ArrayList<>();
        transactionData.add(fromAccount);
        transactionData.add(toAccount);
        transactionData.add(amount);

        try (CSVPrinter printer = new CSVPrinter(new FileWriter("data/transactions.csv", true), CSVFormat.DEFAULT)) {
            if (driver.findElements(By.cssSelector("p.left")).isEmpty()) {
                printer.printRecord();
            }
            printer.printRecord(transactionData);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
