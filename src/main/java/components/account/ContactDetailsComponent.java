package components.account;
import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactDetailsComponent extends AbstractComponent {

    public static final By CONTACT_TEXT_DATA_NAME_FIELD = By.xpath("//div[@records-recordlayoutitem_recordlayoutitem]//slot[@name='outputField']//lightning-formatted-name");
    public static final String CONTACT_TEXT_DATA_FIELD ="//span[text()='%s']/ancestor::div[@records-recordlayoutitem_recordlayoutitem]//div[@class='slds-form-element__control']//span[@class='test-id__field-value slds-form-element__static slds-grow word-break-ie11']";
    String label;
    By textFieldContactLocator;

    public ContactDetailsComponent(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.textFieldContactLocator = By.xpath(String.format(CONTACT_TEXT_DATA_FIELD, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated((textFieldContactLocator)));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    public String getValueContact() {
        return driver.findElement((textFieldContactLocator)).getText();
    }
    public String getValueContactName() {
        return driver.findElement((CONTACT_TEXT_DATA_NAME_FIELD)).getText();
    }


}
