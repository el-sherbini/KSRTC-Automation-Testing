package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By nextRouteBtn = By.xpath("//div[contains(@class, 'popular-routes')]//a[contains(@class, 'carousel-control-next')]");
    public void clickNextRouteBtn() {
        clickElement(nextRouteBtn);
    }

    public By specificRouteBtn = By.xpath("//div[@class=\"carousel-item active\"]//li[1]//a[contains(@onclick, '1467469338690')]");
    public void clickSpecificRouteBtn() {
        clickElement(specificRouteBtn);
    }

    private By departureDatePicker = By.id("txtJourneyDate");
    public void clickDepartureDatePicker() {
        clickElement(departureDatePicker);
    }

    private By departureDatePickerNextBtn = By.xpath("//a[@class='ui-datepicker-next ui-corner-all']");
    public WebElement getDepartureDatePickerNextBtn() {
        return findElement(departureDatePickerNextBtn);
    }

    private By departureDatePickerDayBtn = By.xpath("//div[@id='ui-datepicker-div']//a[normalize-space(text())='8']");
    public WebElement getDepartureDatePickerDayBtn() {
        return findElement(departureDatePickerDayBtn);
    }

    private By searchForBusBtn = By.xpath("//button[contains(@class, 'btn-booking')]");
    public void clickSearchForBusBtn() {
        clickElement(searchForBusBtn);
    }
}