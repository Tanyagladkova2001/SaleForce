package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static components.button_menu.DetailsButton.DETAILS_BUTTON;
import static components.button_menu.DetailsButton.DETAILS_BUTTON_CONTACT;
import static components.button_menu.NewButton.NEW_BUTTON;

public class ContactsPage extends BasePage {
    public ContactsPage(WebDriver driver) {
        super(driver);
    }
    private static final By HEADER = By.xpath("//h1[contains(.,'Contacts')]");
    private static final String BASE_URN = "https://saleforce8.lightning.force.com/lightning/o/Contact/list?filterName=Recent";

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER));

    }
    public void openNewContactForm(){
        driver.findElement(NEW_BUTTON).click();

    }
    public void openDetailsContact() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(DETAILS_BUTTON));
        By by = DETAILS_BUTTON;
        driver.findElement(by).click();
        explicitlyWait.until(ExpectedConditions.attributeContains(DETAILS_BUTTON, "aria-selected", "true"));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(DETAILS_BUTTON_CONTACT));
    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URN);
        return this;
    }

}
