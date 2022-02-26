package components.forms;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputContacts extends AbstractComponent {
    private static final String INPUT_LOCATOR_PATTERN = "//label[contains(.,'%s')]/ancestor::lightning-input//div[@lightning-input_input]//input";

    private String label;
    private By inputLocator;

    public InputContacts(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.inputLocator = By.xpath(String.format(INPUT_LOCATOR_PATTERN, label));
    }
    public void insert(String text) {
        driver.findElement(inputLocator).sendKeys(text);
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(inputLocator).isDisplayed();
    }
}
