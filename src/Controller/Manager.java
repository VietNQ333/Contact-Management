package Controller;


import Model.Contact;
import java.util.ArrayList;

public class Manager {
    Validation v = new Validation();

    public void createContact(ArrayList<Contact> contacts) {
        System.out.print("Enter id contact: ");
        int id = v.checkInputInt();
        System.out.print("Enter first name: ");
        String firstName = v.checkInputString();
        System.out.print("Enter last name: ");
        String lastName = v.checkInputString();
        System.out.print("Enter group: ");
        String group = v.checkInputString();
        System.out.print("Enter address: ");
        String address = v.checkInputString();
        System.out.print("Enter phone: ");
        String phone = v.checkInputPhone();
        contacts.add(new Contact(id, firstName + lastName, group, address,
                phone, firstName, lastName));
        System.err.println("Add successful.");
    }

    public void printAllContact(ArrayList<Contact> contacts) {
        System.out.printf("%-5s%-25s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Name",
                "First name", "Last name", "Group", "Address", "Phone");
        for (Contact contact : contacts) {
            System.out.printf("%-5d%-25s%-20s%-20s%-20s%-20s%-20s\n",
                    contact.getId(), contact.getFullName(),
                    contact.getFirstName(), contact.getLastName(),
                    contact.getGroup(), contact.getAddress(), contact.getPhone());
        }
    }

    public void deleteContactd(ArrayList<Contact> contacts) {
        System.out.print("Enter id: ");
        int idDelete = v.checkInputInt();
        Contact contactDelete = getContactById(contacts, idDelete);
        if (contactDelete == null) {
            System.err.println("Not found contact.");
            return;
        } else {
            contacts.remove(contactDelete);
        }
        System.err.println("Delete successful.");
    }

    public Contact getContactById(ArrayList<Contact> contacts, int idDelete) {
        for (Contact contact : contacts) {
            if (contact.getId() == idDelete) {
                return contact;
            }
        }
        return null;
    }
}
