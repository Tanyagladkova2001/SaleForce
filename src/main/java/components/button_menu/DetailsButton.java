package components.button_menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DetailsButton extends MenuButton{
    public DetailsButton(WebDriver driver, String label) {
        super(driver, label);
    }

    public static final By DETAILS_BUTTON = By.xpath("//a[@data-label='Details']");
    public static final By DETAILS_TAB_PANEL = By.xpath("//div[@class='slds-tabs_default']//flexipage-tab2[@id='tab-1']");

    public static final By DETAILS_BUTTON_CONTACT= By.xpath("//a[@data-label='Details']");

}
