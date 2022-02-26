package steps;

import components.account.ContactDetailsComponent;
import components.builders.ContactBuilder;
import components.forms.*;
import model.ContactModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ContactsPage;

public class ContactSteps extends AbstractStep {
    ContactsPage contactsPage = new ContactsPage(driver);

    public ContactSteps(WebDriver driver) {
        super(driver);
    }

    public ContactSteps createNewContactsAccount(ContactModel contactModel){
        contactsPage.openNewContactForm();
        CreateContactsFormComponent form = new CreateContactsFormComponent(driver);
        Assert.assertTrue(
                form.isComponentDisplayed(),
                form.getClass().getSimpleName().concat(" not displayed")
        );
        fillContactsForm(contactModel);
        form.saveButtonContact();
         validatePageIsLoaded(contactsPage);
        return new ContactSteps(driver);


    }
    private void fillContactsForm(ContactModel contactModel) {

       new InputContacts(driver, "Phone").insert(contactModel.getPhone());

       new InputContacts(driver, "Mobile").insert(contactModel.getMobile());

       new InputContacts(driver, "First Name").insert(contactModel.getFirstName());

       new InputContacts(driver, "Last Name").insert(contactModel.getLastName());

       new InputContacts(driver, "Title").insert(contactModel.getTitle());

       new InputContacts(driver, "Email").insert(contactModel.getEmail());

       new DropdownContact(driver, "Salutation").selectOption(DropdownContact.DROPDOWN_LOCATOR_PATTERN,contactModel.getSalutation());

       new DropdownContact(driver, "Account Name").selectOption(DropdownContact.DROPDOWN_LOCATOR_PATTERN_ACC_NAME,contactModel.getAccountName());
    }
    public void validateContactCreated(ContactModel expectedModel) {
        contactsPage.openDetailsContact();
        ContactModel actualModel = getContactAccount();
        Assert.assertEquals(
                actualModel,
                expectedModel,
                String.format("Contact account is not valid: %s", actualModel)
        );
    }

    private ContactModel getContactAccount( ) {
        ContactModel contactModel = new ContactModel();
        contactModel.setAccountName(new ContactDetailsComponent(driver, "Account Name").getValueContact());
        contactModel.setPhone(new ContactDetailsComponent(driver, "Phone").getValueContact());
        contactModel.setMobile(new ContactDetailsComponent(driver, "Mobile").getValueContact());
        contactModel.setEmail(new ContactDetailsComponent(driver, "Email").getValueContact());
        contactModel.setSalutation(new ContactDetailsComponent(driver, "Name").getValueContactName());
        contactModel.setTitle(new ContactDetailsComponent(driver, "Title").getValueContact());
        return new ContactModel();
    }

}
