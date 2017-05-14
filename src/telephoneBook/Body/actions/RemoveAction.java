package telephoneBook.Body.actions;

import telephoneBook.Body.BookDAO;
import telephoneBook.Body.ConsoleHelper;
import telephoneBook.Body.book.Contact;

import java.util.List;

/**
 * Created by hatak on 2/3/17.
 */
public class RemoveAction extends Action{
    @Override
    public void execute() {
        telephoneBook.Body.book.Book book = BookDAO.getInstance().getBook();
        List<Contact> allContacts = book.getAllContacts();
        for (Contact contact:allContacts) {
            ConsoleHelper.printConsoleLn(contact + "");
        }
        System.out.println("chose Contact name or surname to remove");
        String searched = ConsoleHelper.readConsole();
        for (Contact contact:allContacts) {
        if (searched.equalsIgnoreCase(contact.getName())) {

            }
        }
    }
}

