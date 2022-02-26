package components.builders;

import model.ContactModel;

public class ContactBuilder {
    public ContactBuilder(ContactModel contactModel) {
        this.contactModel = contactModel;
    }

    public ContactBuilder() {

    }

    ContactModel contactModel = new ContactModel();

    public static ContactBuilder newValues() {
        return new ContactBuilder();
    }

    public ContactBuilder setAccountName(String accountName) {
        this.contactModel.setAccountName(accountName);
        return this;
    }

    public ContactBuilder setMobile(String mobile) {
        this.contactModel.setMobile(mobile);
        return this;
    }

    public ContactBuilder setSalutation(String salutation) {
        this.contactModel.setSalutation(salutation);
        return this;
    }

    public ContactBuilder setTitle(String title) {
        this.contactModel.setTitle(title);
        return this;
    }

    public ContactBuilder setEmail(String email) {
        this.contactModel.setEmail(email);
        return this;
    }

    public ContactBuilder setPhone(String phone) {
        this.contactModel.setPhone(phone);
        return this;
    }
    public ContactModel build() {
        return contactModel;
    }
}
