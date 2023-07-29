package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Helpers {
    public static void selectOptionInCustomDropdown(WebElement dropdownElement, String optionText) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(optionText);
    }
}
