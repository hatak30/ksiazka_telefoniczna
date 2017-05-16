package telephoneBook.body.actions;

import telephoneBook.body.BookDAO;
import telephoneBook.body.ConsoleHelper;
import telephoneBook.body.book.Contact;

import java.util.List;

/**
 * Created by hatak on 2/3/17.
 */
public class RemoveAction extends Action {
    @Override
    public void execute() {
        telephoneBook.body.book.Book book = BookDAO.getInstance().getBook();
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