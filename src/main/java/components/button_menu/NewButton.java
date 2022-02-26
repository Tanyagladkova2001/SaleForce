package components.button_menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewButton extends MenuButton{
    public static final By NEW_BUTTON = By.xpath("//li[@class='slds-button slds-button--neutral']//div[contains(@title,'New')]");

    public NewButton(WebDriver driver, String label) {
        super(driver, label);
    }
}
