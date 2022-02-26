package components.button_menu;

import org.openqa.selenium.WebDriver;

public class ContactsButton extends MenuButton{

    public static final String CONTACTS_BUTTON_LABEL = "Contacts";

    public ContactsButton(WebDriver driver) {
        super(driver, CONTACTS_BUTTON_LABEL);
    }
}
