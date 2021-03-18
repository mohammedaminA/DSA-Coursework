package Controllers;

import Helpers.InputHelper;
import Lists.contactDoubleLinkedList;
import Model.Contact;

public class ContactController {

    private contactDoubleLinkedList list;

    public ContactController() {
        this.list = new contactDoubleLinkedList();
        this.list = (this.list.readContactList() == null) ? new contactDoubleLinkedList() : this.list.readContactList();
        System.out.println( "Your contact list is successfully loaded");
    }

    public void run() {
        boolean end = false;
        do {
            char input = displayContactListMenu();
            switch (input) {
                case 'A':
                displayList();
                break;
                case 'B':
                displayListWithInfo();
                break;
                case 'C':
                addContactToList();
                break;
                case 'S':
                char searchUsing = displaySearchMenu();
                switch (searchUsing) {
                    case 'A':
                    case 'a':
                        searchContactFromList("Phone Number");
                        break;
                    case 'B':
                    case 'b':
                        searchContactFromList("Name");
                        break;
                    default:
                        run();
                        break;
                }
                break;

            case 'D':
                char deleteUsing = displayDeleteMenu();
                switch(deleteUsing) {
                    case 'A':
                    case 'a':
                        deleteContactFromList("Phone Number");
                        break;
                    case 'B':
                    case 'b':
                        deleteContactFromList("Name");
                        break;
                    default:
                    run();
                    break;
                }
                break;

            case 'F':
            this.list.saveContactList(list);;
            end = true;
            }
        }  while (!end);
    }

    private char displayContactListMenu() {
        InputHelper inputHelper = new InputHelper();
        System.out.printf("\n%s\t%s\t%s\t%s\t%s\t%s", "\tA. Display Contact List", "B. Display Contact with infos\n", "C. Add a new Contact", "S. Search Contacts\n", "D. Delete Contact\n", "F. Exit\n");
        return inputHelper.readCharacter("Enter Choice", "ABCSDF");   
    }

    private char displaySearchMenu() {
    InputHelper inputHelper = new InputHelper();
    System.out.printf("\n%s\t%s\t%s", "\tA.Search by Phone Number\n", "B.Search by Contact Name\n", "C.Cancel\n");
    return inputHelper.readCharacter("Enter Choice", "ABC");
    }

    private char displayDeleteMenu() {
        InputHelper inputHelper = new InputHelper();
        System.out.printf("\n%s\t%s\t%s", "\tA. Delete by Phone Number\n", "B. Delete By Contact Name\n", "C. Cancel\n");
        return inputHelper.readCharacter("Enter Choice", "ABC");
    }

    private void displayList() {
        if (this.list.getSize() == 0) {
            System.out.println(" List is Empty");
        } else {
            System.out.println(this.list.toString());
        }
    }

    private void displayListWithInfo() {
        if (this.list.getSize() == 0) {
            System.out.println(" List is Empty");
        } 
        this.list.display();
    }

    private void addContactToList() {
        InputHelper inputHelper = new InputHelper();
        String phoneNumber = inputHelper.readString("Enter Phone Number. Eg: 0929232033");
        String firstName = inputHelper.readString("Enter First Name");
        String lastName = inputHelper.readString("Enter Last Name");
        String email = inputHelper.readString("Enter Email Address");
        String date = inputHelper.readDate("Enter Date in format DD/MM/YYYY");
        String type = inputHelper.readString("Enter Contact Type (Personal or Business)");

        Contact newContact = new Contact(firstName, lastName, phoneNumber, email, date, type);
        list.addToEnd(newContact);
        System.out.println("Contact " + firstName + " " + lastName + " added Succesfully!");

    }

    private void searchContactFromList(String searchable) {
        InputHelper inputHelper = new InputHelper();
        try {
            if (searchable.equals("phoneNumber")) {
                String phoneNumber = inputHelper.readString("Enter a valid phone number. eg: 0929232033");
                this.list.searchByPhoneNumber(phoneNumber).getContact().display();
                
            } else {
                String name = inputHelper.readString("Enter Contact Name");
                this.list.searchByName(name).getContact().display();
            }
        } catch(Exception x) {
            System.out.println("Invalid Search");
        }
    }

    
private void deleteContactFromList(String searchable) {
    InputHelper inputHelper = new InputHelper();
    if (searchable.equals("phoneNumber")) {
        String phoneNumber = inputHelper.readString("Enter a Valid Phone Number. Eg: 0929232033");
        this.list.deleteByNumber(phoneNumber);
    } else {
        String name = inputHelper.readString(" Enter a Valid Contact Name");
        this.list.deleteByName(name);
    }
}

}
