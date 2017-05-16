package telephoneBook.body.book;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by krzysiek on 08.01.17.
 */
public class Book implements Serializable {

    public static long serialVersionUID = 78437625;

    private List<Contact> contacts = new ArrayList<>();

    public void addContact(final Contact contact) {
        this.contacts.add(contact);
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }
}