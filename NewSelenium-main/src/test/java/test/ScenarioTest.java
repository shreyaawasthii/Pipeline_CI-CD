package test;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

public class ScenarioTest {

    private WebDriver driver;
    private BaseTest baseTest;
    private OpenNewAccount openNewAccount;
    private Register registerPage;
    private SignIn signIn;
    private BillPay billpay;
    private RequestLoan requestLoan;

    public static final String first_name = "Atulya";
    public static final String last_name = "Sharma";
    public static final String address = "Sector 76";
    public static final String city = "Noida";
    public static final String state = "Delhi";
    public static final String zipCode = "201305";
    public static final String phone_no = "1234567890";
    public static final String SSN = "1234";
    public static final String username = "sharmaji";
    public static final String password = "password123";

    public static final String payee_name = "Samanta";
    public static final String toAccount = "12345";
    public static final String amount = "100";

    @BeforeTest
    public void setUpRegisterPage() {
        baseTest = new BaseTest(driver);
        baseTest.setUp();
        driver = baseTest.getDriver();
            registerPage = new Register(driver);
            registerPage.registerUser(first_name, last_name, address, city, state, zipCode, phone_no, SSN, username, password);
                signIn = new SignIn(driver);
                signIn.signInUser(username, password);
    }

    @BeforeMethod
    public void setUp() {
        openNewAccount = new OpenNewAccount(driver);
        billpay = new BillPay(driver);
        requestLoan = new RequestLoan(driver);
    }


    @Test(priority = 0)
    public void openNewAccount() throws InterruptedException {
        openNewAccount.openCheckingAccount();
        openNewAccount.openSavingsAccount();

    }
    @Test(priority = 1)
    public void transferFundsTest() throws InterruptedException {
        TransferFunds transferFundsPage = new TransferFunds(driver);
        transferFundsPage.transferFunds("100");
        transferFundsPage.transferFunds("1000");
        transferFundsPage.transferFunds("10000");
        transferFundsPage.transferFunds("100000");
        transferFundsPage.transferFunds("1000000");
        transferFundsPage.transferUndefinedFunds("500");
    }

    @Test(priority = 2)
    public void billPayTest() throws InterruptedException{
        billpay.billPayfromAccountHolder(first_name, address, city, state, zipCode, phone_no, toAccount, amount);
        billpay.billPayWithDifferentAccount(payee_name, address, city, state, zipCode, phone_no, "12790", amount);
    }

    @Test(priority = 3)
    public void RequestLoan() throws InterruptedException{
        requestLoan.requestLoan("100000", "10000");
        requestLoan.requestLoan("100", "100000");
        requestLoan.requestLoanForEmptyField();
    }

    @AfterClass
    public void tearDown() {
        baseTest.tearDown();
    }
}

