package com.tutorial.telephonebook.actions;


import com.tutorial.telephonebook.BookDAO;
import com.tutorial.telephonebook.ConsoleHelper;
import com.tutorial.telephonebook.book.Book;
import com.tutorial.telephonebook.book.Contact;

import java.util.List;

/**
 * Created by hatak on 2/3/17.
 */
public class RemoveAction extends Action {
    @Override
    public void execute() {
        Book book = BookDAO.getInstance().getBook();
        List<Contact> allContacts = book.getAllContacts();
        for (Contact contact : allContacts) {
            ConsoleHelper.printConsoleLn(contact + "");
        }
        System.out.println("chose Contact name to remove");
        String searched = ConsoleHelper.readConsole();
        Contact removeContact = null;
        for (Contact contact : allContacts) {
            if (searched.equalsIgnoreCase(contact.getName())) {
                removeContact = contact;
                break;
            }
        }
        if (removeContact != null) {
            allContacts.remove(removeContact);
        }
        BookDAO.getInstance().save();
    }
}