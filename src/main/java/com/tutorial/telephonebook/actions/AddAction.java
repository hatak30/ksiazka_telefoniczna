package com.tutorial.telephonebook.actions;


import com.tutorial.telephonebook.BookDAO;
import com.tutorial.telephonebook.ConsoleHelper;
import com.tutorial.telephonebook.book.Book;
import com.tutorial.telephonebook.book.Contact;

/**
 * Created by hatak on 2/3/17.
 */
public class AddAction extends Action {

    public static final String POSITIVE_ANSWER = "y";

    @Override
    public void execute() {
        ConsoleHelper.printConsoleLn("Add contact information");
        ConsoleHelper.printConsole("\tName :");
        String name = ConsoleHelper.readConsole();
        ConsoleHelper.printConsole("\tSurmane :");
        String surname = ConsoleHelper.readConsole();

        Contact contact = null;
        String answer;
        do {
            ConsoleHelper.printConsole("\tPhone number: ");
            String phoneNumber = ConsoleHelper.readConsole();

            if (contact == null) {
                contact = new Contact(name, surname, phoneNumber);
            } else {
                contact.addNumber(phoneNumber);
            }

            ConsoleHelper.printConsoleLn("Do you want to provide another number [y/n]");
            ConsoleHelper.printConsole("\tAnswer :");
            answer = ConsoleHelper.readConsole();
        } while (answer.equalsIgnoreCase(POSITIVE_ANSWER));

        Book book = BookDAO.getInstance().getBook();
        book.addContact(contact);
        BookDAO.getInstance().save();


        String[] split = ConsoleHelper.readConsole().split(" ");
    }
}
