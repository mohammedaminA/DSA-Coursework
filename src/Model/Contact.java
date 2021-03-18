

package Model;

import java.util.Objects;

import DAOS.IDisplayable;
import java.io.Serializable;


/**
 * @author MohammedaminS
 */
public class Contact implements IDisplayable, Serializable {
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String email;
    private String date;
    private String contactType;


    /**
     * @param firstName
     * @param lastName
     * @param telephoneNumber
     * @param email
     * @param date
     * @param contactType
     */
    public Contact(String firstName, String lastName, String telephoneNumber, String email, String date, String contactType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.date = date;
        this.contactType = contactType;
    }

    /**
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * @param telephoneNumber
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    /**
     * @return
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return
     */
    public String getContactType() {
        return contactType;
    }

    /**
     * @param contactType
     */
    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    /**
     * Displays Contact List
     */
    @Override
    public void display() {
        final String textFormat = "%-30s %s\n";
        System.out.printf("%s\n" + textFormat + textFormat + textFormat + textFormat + textFormat,  "Contact Info: \n" +
                "\n", "Name: ", getLastName(), "Phone Number : ", getTelephoneNumber(), "Email : ", getEmail(), "Date Registered: ", getDate(),
         "Contact Type: ", getContactType());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return getTelephoneNumber() == contact.getTelephoneNumber() && getContactType() == contact.getContactType() && getFirstName().equals(contact.getFirstName()) && getLastName().equals(contact.getLastName()) && getEmail().equals(contact.getEmail()) && getDate().equals(contact.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getTelephoneNumber(), getEmail(), getDate(), getContactType());
    }

    @Override
    public String toString() {
        return "Model.Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephoneNumber=" + telephoneNumber +
                ", email='" + email + '\'' +
                ", date=" + date +
                ", contactType=" + contactType +
                '}';
    }
}
