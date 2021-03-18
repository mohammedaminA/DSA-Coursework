package DAOS;

import java.io.File;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Logger;
import java.util.logging.Level;
import Lists.contactDoubleLinkedList;



public class DAO {

    public void loadList(contactDoubleLinkedList list) {
        ObjectOutputStream ContactOutputStream  = null;
        try {
            ContactOutputStream  = new ObjectOutputStream(new FileOutputStream("contactList.txt"));
        } catch (FileNotFoundException X) {
            Logger.getLogger(contactDoubleLinkedList.class.getName()).log(Level.SEVERE, null, X);
        } catch (IOException X) {
            Logger.getLogger(contactDoubleLinkedList.class.getName()).log(Level.SEVERE, null, X);
        } try {
            ContactOutputStream.writeObject(list);
        } catch (IOException X) {
            Logger.getLogger(contactDoubleLinkedList.class.getName()).log(Level.SEVERE, null, X);
        } finally{
            try {
                ContactOutputStream.close();
            } catch (IOException X) {
                Logger.getLogger(contactDoubleLinkedList.class.getName()).log(Level.SEVERE, null, X) ;
            }

            }

    }

    public contactDoubleLinkedList readList() {
        File file = new File("ContactList.txt");
        ObjectInputStream ContactInputStream  = null;
        try {
            ContactInputStream = new ObjectInputStream(new FileInputStream("contactList.txt"));
        } catch (EOFException X) {}
        catch(FileNotFoundException X) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, X);
        } catch (IOException X) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, X);
        }
        contactDoubleLinkedList list = new contactDoubleLinkedList();
        try {
            if(file.length() == 0)
                return null;
            else list = (contactDoubleLinkedList) ContactInputStream.readObject();
        }catch(IOException | ClassNotFoundException X) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, X);
        }

        try {
            ContactInputStream.close();
        } catch (IOException X) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, X);
        }

        return list;
    }


}

