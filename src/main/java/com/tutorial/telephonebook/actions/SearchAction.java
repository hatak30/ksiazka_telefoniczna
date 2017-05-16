package com.tutorial.telephonebook.actions;

import com.tutorial.telephonebook.BookDAO;
import com.tutorial.telephonebook.ConsoleHelper;
import com.tutorial.telephonebook.book.Book;
import com.tutorial.telephonebook.book.Contact;


import java.util.List;

/**
 * Created by hatak on 2/3/17.
 */
public class SearchAction extends Action {
    @Override
    public void execute() {
        Book book = BookDAO.getInstance().getBook();
        System.out.print("Searched personal data: ");
        String searched = ConsoleHelper.readConsole();
        List<Contact> allContacts = book.getAllContacts();
        for (Contact contact : allContacts) {
            if (contact.getName().contains(searched)) {
                System.out.println(contact.toString());
            }
            if (contact.getSureName().contains(searched)) {
                System.out.println(contact.toString());
            }
            if (contact.getNumbers().contains(searched)) {
                System.out.println(contact.toString());
            }
        }
    }
}