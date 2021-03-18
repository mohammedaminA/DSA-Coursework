package Lists;

import Model.Contact;
import Node.contactNode;
import DAOS.DAO;
import DAOS.IDisplayable;
import java.io.Serializable;

public class contactDoubleLinkedList implements IDisplayable, Serializable {

        private contactNode head;
        private contactNode tail;
        private int size;


        public void addToFront(Contact contact) {
            contactNode node = new contactNode(contact);

            if (head == null) {
                tail = node;
            }
            else {
                head.setPrevious(node);
                node.setNext(head);
            }

            head = node;
            size++;
        }

        public void addToEnd(Contact contact) {
            contactNode node = new contactNode(contact);
            if (tail == null) {
                head = node;
            }
            else {
                tail.setNext(node);
                node.setPrevious(tail);
            }

            tail = node;
            size++;
        }

        public contactNode removeFromFront() {
            if (isEmpty()) {
                return null;
            }

            contactNode removedNode = head;

            if (head.getNext() == null) {
                tail = null;
            }
            else {
                head.getNext().setPrevious(null);
            }

            head = head.getNext();
            size--;
            removedNode.setNext(null);
            return removedNode;
        }

        public contactNode removeFromEnd() {
            if (isEmpty()) {
                return null;
            }

            contactNode removedNode = tail;

            if (tail.getPrevious() == null) {
                head = null;
            }
            else {
                tail.getPrevious().setNext(null);
            }

            tail = tail.getPrevious();
            size--;
            removedNode.setPrevious(null);
            return removedNode;
        }

        public contactNode searchByPhoneNumber(String phoneNumber) {
            int i = 0;

            contactNode newNode = head;
            if (head == null) {
                System.out.println(" List is Empty");
                return null;
            }
            while (newNode != null) {
                if (newNode.getContact().getTelephoneNumber() == phoneNumber) {
                    return newNode;
                }
                newNode = newNode.getNext();
                i++;
            }
            return null;
        }

        public contactNode searchByName (String name) {
            int i = 0;

            contactNode newNode = head;
            if (head == null) {
                System.out.println( "List is Empty");
                return null;
            }

            while (newNode!= null) {
                if (newNode.getContact().getLastName().equals(name)) {
                    return newNode;
                }

                newNode = newNode.getNext();
                i++;
            }
            return null;
        }

        public void deleteByNumber(String searchable) {
            if (isEmpty()) {
                System.out.println("List is Empty");
                return;
            }else {
                contactNode newNode = head;
                while (newNode != null) {
                    if (newNode.getContact().getTelephoneNumber() == searchable) {
                        if (newNode == head) {
                            System.out.println(searchable + " is deleted succesfully.");
                            removeFromFront();
                            return;
                        } else if (newNode == tail) {
                            System.out.println(searchable + " is deleted successfully");
                            removeFromEnd();
                            return;
                        } else {
                            System.out.println(searchable + " is deleted successfully");
                            newNode.setNext(newNode.getPrevious());
                            newNode.setPrevious(newNode.getNext());
                            newNode = null;
                        }
                        size--;
                        return;
                    }
                    newNode = newNode.getNext();
                }
            }
            System.out.println("The phone number is not in the list");
        } 

        public void deleteByName(String searchable) {
            if (isEmpty()) {
                System.out.println("List is Empty");
                return;

            } else {
                contactNode newNode = head;

                while (newNode != null) {
                    if (newNode.getContact().getLastName().equals(searchable)) {
                        if (newNode == head) {
                            System.out.println(searchable + " is deleted successfully");
                            removeFromFront();
                            return;
                        } else if (newNode == tail);
                        System.out.println(searchable + " is deleted succesfully");
                        removeFromEnd();
                        return;
                    } else {
                        System.out.println(searchable + " is deleted succesfully");
                        newNode.setNext(newNode.getPrevious());
                            newNode.setPrevious(newNode.getNext());
                            newNode = null;
                    }
                    size--;
                    return;
                }
                newNode = newNode.getNext();
            }
            System.out.println("List does not contain the name: " + searchable);
        }
    

        public void saveContactList(contactDoubleLinkedList list) {
            DAO dao = new DAO();
            dao.loadList(list);
        }

        public contactDoubleLinkedList readContactList() {
            DAO dao = new DAO();
            return dao.readList();
        }

        public int getSize() {
            return size;
        }

        public boolean isEmpty() {
            return head == null;
        }

        @Override
	public void display() {
		contactNode node = head;
		while (node != null) { //keep going until there is no more
			node.display();
			node = node.getNext();;
		}
	}




    }


