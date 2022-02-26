package pages;

import components.button_menu.NewButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static components.button_menu.DetailsButton.DETAILS_BUTTON;
import static components.button_menu.DetailsButton.DETAILS_TAB_PANEL;

public class AccountPage extends BasePage {

    private static final String BASE_URN = "https://nonamecomp.lightning.force.com/lightning/o/Account/list?filterName=Recent";

    private static final By HEADER = By.xpath("//h1[contains(.,'Account')]");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER));
    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URN);
        return this;
    }

    public void openNewAccountForm() {
        driver.findElement(NewButton.NEW_BUTTON).click();
    }

    public void openDetails() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(DETAILS_BUTTON));
        By by = DETAILS_BUTTON;
        driver.findElement(by).click();
        explicitlyWait.until(ExpectedConditions.attributeContains(DETAILS_BUTTON, "aria-selected", "true"));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(DETAILS_TAB_PANEL));
    }

}
