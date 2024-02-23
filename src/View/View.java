package View;

import Controller.Manager;
import Model.Contact;
import java.util.ArrayList;


public class View extends Menu<String> {
    ArrayList<Contact> contacts = new ArrayList<>();
    static String[] menu = {"add a contact", "display all contact", "Delete a contact", "Exit"};
    public View() {
        super("==================Contact program==================", menu);
    }
    Manager mn = new Manager ();
    @Override
    public void execute(int n) {
            switch (n) {
                case 1:
                    mn.createContact(contacts);
                    break;
                case 2:
                    mn.printAllContact(contacts);
                    break;
                case 3:
                    mn.deleteContactd(contacts);
                    break;
                case 4:
                    System.out.println("==================Exiting the program.==================");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Invalid choosen. Please try again!!");
            } 
    }
    public static void main(String[] args) {
        View mn = new View();
        while (true){
            mn.run();
        }
    }
}
