package telephoneBook.body.actions;

import telephoneBook.body.BookDAO;
import telephoneBook.body.ConsoleHelper;
import telephoneBook.body.book.Contact;

import java.util.List;

/**
 * Created by hatak on 2/3/17.
 */
public class SearchAction extends Action {
    @Override
    public void execute() {
        telephoneBook.body.book.Book book = BookDAO.getInstance().getBook();
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