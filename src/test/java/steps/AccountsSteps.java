package steps;

import components.account.AccountDetailsComponent;
import components.forms.CreateContactsFormComponent;
import components.forms.DropdownAccount;
import components.forms.InputAccount;
import model.AccountModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AccountPage;

public class AccountsSteps extends AbstractStep {

    private AccountPage accountPage;

    public AccountsSteps(WebDriver driver) {
        super(driver);
    }

    public AccountsSteps createNewAccount(AccountModel accountModel) {
        accountPage = new AccountPage(driver);
        accountPage.openNewAccountForm();
        CreateContactsFormComponent form = new CreateContactsFormComponent(driver);
        Assert.assertTrue(
                form.isComponentDisplayed(),
                form.getClass().getSimpleName().concat(" not displayed")
        );
        fillAccountForm(accountModel);
        form.saveButtonAccount();
        validatePageIsLoaded(accountPage);
        return this;
    }

    private void fillAccountForm(AccountModel accountModel) {
        InputAccount accountNameInputAccount = new InputAccount(driver, "Account Name");
        accountNameInputAccount.insert(accountModel.getAccountName());
        InputAccount phoneInputAccount = new InputAccount(driver, "Phone");
        phoneInputAccount.insert(accountModel.getPhone());
        new InputAccount(driver, "Website").insert(accountModel.getWebsite());
        new InputAccount(driver, "Employees").insert(String.valueOf(accountModel.getEmployees()));
        new DropdownAccount(driver, "Type").selectOption(accountModel.getType());
        new DropdownAccount(driver, "Industry").selectOption(accountModel.getIndustry());
    }

    public void validateAccountCreated(AccountModel expectedModel) {
        accountPage.openDetails();
        AccountModel actualModel = getActualAccount();
        Assert.assertEquals(
                actualModel,
                expectedModel,
                String.format("Account is not valid: %s", actualModel)
        );
    }

    private AccountModel getActualAccount( ) {
        AccountModel actualModel = new AccountModel();
        actualModel.setAccountName(new AccountDetailsComponent(driver, "Account Name").getValue());
        actualModel.setPhone(new AccountDetailsComponent(driver, "Phone").getValue());
        actualModel.setWebsite(new AccountDetailsComponent(driver, "Website").getValue());
        actualModel.setEmployees(Integer.parseInt(new AccountDetailsComponent(driver, "Employees").getValue()));
        actualModel.setType(new AccountDetailsComponent(driver, "Type").getValue());
        actualModel.setIndustry(new AccountDetailsComponent(driver, "Industry").getValue());
        return actualModel;
    }

}