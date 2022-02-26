package components.forms;
import components.AbstractComponent;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateContactsFormComponent extends AbstractComponent {

    private static final By HEADER = By.xpath("//h2[contains(.,'New Contact')]");
    private static final By SAVE_BUTTON =
            By.xpath("//div[contains(@class,'forceRecordEditActions')]//button[contains(@class,'uiButton')]/span[text()='Save']");

    private static final By SAVE_BUTTON_CONTACTS = By.xpath("//li[@class='slds-button-group-item visible']//button[@name='SaveEdit']");


    public CreateContactsFormComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    public void saveButtonAccount() {
        WebElement button = driver.findElement(SAVE_BUTTON);
        System.out.printf("button is displayed: %s\n", button.isDisplayed());
        System.out.printf("button is enabled: %s\n", button.isEnabled());
        button.click();
    }

        public void saveButtonContact() {
            WebElement button = driver.findElement(SAVE_BUTTON_CONTACTS);
            System.out.printf("button is displayed: %s\n", button.isDisplayed());
            System.out.printf("button is enabled: %s\n", button.isEnabled());
            button.click();
        }




//        Actions()
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(SAVE_BUTTON));
//        var buttonFooter = driver.findElement(By.cssSelector("div.forceRecordEditActions"));
//        System.out.printf("button is displayed: %s\n", buttonFooter.isDisplayed());
//        System.out.printf("button is enabled: %s\n", buttonFooter.isEnabled());
    }

