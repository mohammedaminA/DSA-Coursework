package App;
import Controllers.ContactController;

/**
 * author MohammedaminA
 */
public class ContactApp {
    public static void run() {
        System.out.println(" Welecome to the Contact App!");
        ContactController controller = new ContactController();
        controller.run();

        System.out.println(" Successfully saved! \nThank you for usingA the app. Goodbye!\n");
    }

    public static void main (String [] args) {
        ContactApp app = new ContactApp();
        app.run();
    }
}
