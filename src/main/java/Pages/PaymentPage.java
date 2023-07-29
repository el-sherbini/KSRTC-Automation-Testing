package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage extends BasePage {
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    private By iframe = By.xpath("//iframe[@class='razorpay-checkout-frame']");
    public WebElement getIframe() {
        return findElement(iframe);
    }

    private By paymentMethodBtn = By.xpath("//button[@class=\"new-method has-tooltip false svelte-sps7l1\"][1]");
    public void clickPaymentMethodBtn() {
        clickElement(paymentMethodBtn);
    }

    private By cardNoTxtFld = By.id("card_number");
    public void setCardNoTxtFld(String cardNo) {
        sendKeysToElement(cardNoTxtFld, cardNo);
    }

    private By cardExpiryTxtFld = By.id("card_expiry");
    public void setCardExpiryTxtFld(String cardExpiry) {
        sendKeysToElement(cardExpiryTxtFld, cardExpiry);
    }

    private By cardCvvTxtFld = By.id("card_cvv");
    public void setCardCvvTxtFld(String cardCvv) {
        sendKeysToElement(cardCvvTxtFld, cardCvv);
    }
}