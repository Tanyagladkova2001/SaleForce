package components.forms;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DropdownContact extends AbstractComponent {
    private String label;
    private By dropdownLocator;
    public By patterns;

    public static final By DROPDOWN_LOCATOR_PATTERN =
      By.xpath("//div//lightning-base-combobox//ancestor::div//label[@class='slds-form-element__label' and contains(.,'Salutation')]//ancestor::div//button[@lightning-basecombobox_basecombobox]//span");

    public static final By DROPDOWN_LOCATOR_PATTERN_ACC_NAME = By.xpath("//div[@lightning-basecombobox_basecombobox]//ancestor::lightning-grouped-combobox//label[@class='slds-form-element__label' and contains(.,'Account Name')]//ancestor::div//input[@lightning-basecombobox_basecombobox]");

    private static final String OPTION_LIST_PATTERN ="//span[@class='slds-media__body']//span[@title='%s']";

    public DropdownContact(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.dropdownLocator=patterns;

    }
    private void openOptionsPopup(By patterns) {
        driver.findElement(patterns).click();
    }

    public void selectOption(By patterns,String optionName) {
        openOptionsPopup(patterns);
        By optionLocator = By.xpath(String.format(OPTION_LIST_PATTERN,optionName));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        driver.findElement(optionLocator).click();

    }

    public boolean isComponentDisplayed(By patterns) {
        return driver.findElement(patterns).isDisplayed();

    }

    @Override
    public boolean isComponentDisplayed() {
        return false;
    }
}
