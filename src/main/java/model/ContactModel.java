package model;

import java.util.Objects;

public class ContactModel {
    String AccountName;
    String Phone;
    String Mobile;
    String Salutation;
    String LastName;
    String FirstName;
    String Title;
    String Email;
    String NameField;

    public String getNameField() {
        return NameField;
    }

    public void setNameField(String nameField) {
        NameField = nameField;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactModel account = (ContactModel) o;
        return Email == account.Email && Objects.equals(AccountName, account.AccountName) && Objects.equals(Phone, account.Phone) && Objects.equals(Title, account.Title) && Objects.equals(Salutation, account.Salutation) && Objects.equals(FirstName, account.FirstName)&& Objects.equals(LastName, account.LastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountName(), getPhone(), getMobile(), getSalutation(), getLastName(), getFirstName(), getTitle(), getEmail(), getNameField());
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getSalutation() {
        return Salutation;
    }

    public void setSalutation(String salutation) {
        Salutation = salutation;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
