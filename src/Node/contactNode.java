package Node;

import Model.Contact;
import DAOS.IDisplayable;
import java.io.Serializable;

public class contactNode implements IDisplayable, Serializable {
    private Contact contact;
    private contactNode next;
    private contactNode previous;

    public contactNode(Contact contact) {

        this.contact = contact;
    }


    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Contact getContact() {
        return contact;
    }

    public contactNode getNext() {
        return next;
    }

    public void setNext(contactNode next) {
        this.next = next;
    }

    public contactNode getPrevious() {
        return previous;
    }

    public void setPrevious(contactNode previous) {
        this.previous = previous;
    }

    public String toString() {
        return contact.toString();
    }

    @Override
	public void display() {
		getContact().display();
	}
}
