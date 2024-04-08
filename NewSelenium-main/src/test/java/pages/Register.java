package pages;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Register extends BaseTest {

    @FindBy(xpath = "//a[text()='Register']")
    private WebElement registerLink;

    @FindBy(id = "customer.firstName")
    private WebElement firstName;

    @FindBy(id = "customer.lastName")
    private WebElement lastName;

    @FindBy(id = "customer.address.street")
    private WebElement address;

    @FindBy(id = "customer.address.city")
    private WebElement city;

    @FindBy(id = "customer.address.state")
    private WebElement state;

    @FindBy(id = "customer.address.zipCode")
    private WebElement zipCode;

    @FindBy(id = "customer.phoneNumber")
    private WebElement phoneNumber;

    @FindBy(id = "customer.ssn")
    private WebElement ssn;

    @FindBy(id = "customer.username")
    private WebElement username;

    @FindBy(id = "customer.password")
    private WebElement password;

    @FindBy(id = "repeatedPassword")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@type= 'submit' and @value='Register']")
    private WebElement registerButton;

    protected WebDriver driver;
    public static WebDriverWait wait;

    public Register(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Register() {
    }

    public void registerUser(String fName, String lName, String addr, String cityName, String stateName, String zip, String phone, String ssnNo, String uname, String pwd) {
        registerLink.click();
        fillRegistrationForm(fName, lName, addr, cityName, stateName, zip, phone, ssnNo, uname, pwd);
        clickRegisterButton();
    }

    private void fillRegistrationForm(String fName, String lName, String addr, String cityName, String stateName, String zip, String phone, String ssnNo, String uname, String pwd) {
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        address.sendKeys(addr);
        city.sendKeys(cityName);
        state.sendKeys(stateName);
        zipCode.sendKeys(zip);
        phoneNumber.sendKeys(phone);
        ssn.sendKeys(ssnNo);
        username.sendKeys(uname);
        password.sendKeys(pwd);
        confirmPassword.sendKeys(pwd);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }
}

