package saleforce;

import model.ContactModel;
import org.testng.annotations.Test;
import utils.ContactModelUtils;

public class AddContactsTest extends BaseTest{
    ContactModel testContact = ContactModelUtils.getContactsModel();
    ContactModel testContactTwo = ContactModelUtils.checkValidationResults();

    @Test
    public void AddContactTest(){
        mainSteps
        .openSaleforceLoginPage()
                .loginWithValidCreds()
                .openContactsPage()
                .createNewContactsAccount(testContact)
                .validateContactCreated(testContactTwo);

    }

}
