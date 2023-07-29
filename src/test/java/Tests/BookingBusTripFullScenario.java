package Tests;

import Pages.HomePage;
import Pages.PaymentPage;
import Pages.ResultsPage;
import Utils.TestConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static Utils.Helpers.selectOptionInCustomDropdown;

public class BookingBusTripFullScenario {
    private static WebDriver driver;
    private JavascriptExecutor jsExecutor;
    private HomePage homePage;
    private ResultsPage resultsPage;
    private PaymentPage paymentPage;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024,768));

        homePage = new HomePage(driver);
        resultsPage = new ResultsPage(driver);
        paymentPage = new PaymentPage(driver);

        jsExecutor = (JavascriptExecutor) driver;

        homePage.openURL(TestConfig.BASE_URL);
    }

    @Test
    public void testChooseRoutes(){
        homePage.clickNextRouteBtn();
        homePage.clickSpecificRouteBtn();
    }

    @Test (dependsOnMethods = "testChooseRoutes")
    public void testChooseDepartureDate() {
        jsExecutor.executeScript("arguments[0].click();", homePage.getDepartureDatePickerNextBtn());
        jsExecutor.executeScript("arguments[0].click();", homePage.getDepartureDatePickerDayBtn());
    }

    @Test (dependsOnMethods = "testChooseRoutes")
    public void testSearchForBus() {
        homePage.clickSearchForBusBtn();
    }

    @Test (dependsOnMethods = "testSearchForBus")
    public void testSelectSeat() {
        resultsPage.clickSelectSeatBtn();
    }

    @Test (dependsOnMethods = "testSelectSeat")
    public void testSelectAvailableSeat() {
        resultsPage.clickAvailableSeatBtn();
    }

    @Test (dependsOnMethods = "testSelectAvailableSeat")
    public void testSelectBoardingDroppingPoints() {
        resultsPage.clickBoardingPointSelect();
        resultsPage.clickDroppingPointSelect();
    }

    @Test (dependsOnMethods = "testSelectBoardingDroppingPoints")
    public void testFillCustomerDetails() {
        resultsPage.setMobileNoTxtFld("6789125987");
        resultsPage.setEmailTxtFld("test@test.com");
    }

    @Test (dependsOnMethods = "testSelectBoardingDroppingPoints")
    public void testFillPassengerDetails() {
        resultsPage.setNameTxtFld("test");
        resultsPage.setAgeTxtFld("25");

        selectOptionInCustomDropdown(resultsPage.getGenderDropDown(), "MALE");
        selectOptionInCustomDropdown(resultsPage.getConcessionDropDown(), "GENERAL PUBLIC");
        selectOptionInCustomDropdown(resultsPage.getCountryDropDown(), "INDIA");
    }

    @Test (dependsOnMethods = "testFillPassengerDetails")
    public void testClickMakePayment() {
        resultsPage.clickMakePaymentBtn();
    }

    @Test (dependsOnMethods = "testClickMakePayment")
    public void testAddPaymentData() {
        driver.switchTo().frame(paymentPage.getIframe());
        paymentPage.clickPaymentMethodBtn();
        paymentPage.setCardNoTxtFld("378282246310005");
        paymentPage.setCardExpiryTxtFld("03/26");
        paymentPage.setCardCvvTxtFld("1234");
    }
}
