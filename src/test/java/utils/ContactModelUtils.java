package utils;

import components.builders.ContactBuilder;
import model.ContactModel;

public class ContactModelUtils {
    public static ContactModel getContactsModel() {
        ContactModel contactModel = new ContactModel();
        contactModel.setPhone("+375223233");
        contactModel.setMobile("+3753838389");
        contactModel.setAccountName("Username");
        contactModel.setSalutation("Ms.");
        contactModel.setEmail("tanya@mail.ru");
        contactModel.setFirstName("Tanya");
        contactModel.setLastName("Gladkova");
        contactModel.setTitle("IDK");
        return contactModel;

    }
    public static ContactModel checkValidationResults() {
         ContactBuilder.newValues()
                .setAccountName("Username")
                .setPhone("+375223233")
                .setEmail("tanya@mail.ru")
                .setTitle("IDK")
                .setSalutation("Ms. Tanya Gladkova")
                .setMobile("+3753838389")
                .build();
         return new ContactModel();
    }

}
