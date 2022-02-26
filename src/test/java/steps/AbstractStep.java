package steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BasePage;
import saleforce.BaseTest;

public class AbstractStep extends BaseTest {

    WebDriver driver;


    public AbstractStep(WebDriver driver) {
        this.driver = driver;
    }

    protected void validatePageIsLoaded(BasePage page) {
        Assert.assertTrue(page.isPageLoaded(), page.getClass().getSimpleName().concat(" is not opened: "));
    }

}