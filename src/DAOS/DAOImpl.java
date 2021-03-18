package DAOS;

import Model.Contact;

public class DAOImpl implements IDisplayable {

    @Override
    public void display() {
        System.out.println("Successfully Implemented");

        Contact Mohammed = new Contact("Mohammedamin", "Abdullah", "0929232033",
                "mamibubu999@gmail.com", "3/12/2021", "Personal" );

        Mohammed.display();
    }
}
