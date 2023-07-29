package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

public class Helpers {
    public static void selectOptionInCustomDropdown(WebElement dropdownElement, String optionText) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(optionText);
    }

    @DataProvider(name = "passengerData")
    public static Object[][] getPassengerData() {
        return new Object[][] {
                {"passenger", "25", "MALE", "GENERAL PUBLIC", "INDIA", 0},
                {"passengerr", "30", "FEMALE", "GENERAL PUBLIC", "INDIA", 1},
        };
    }
}
