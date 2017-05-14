package telephoneBook.Body.actions;

import telephoneBook.Body.BookDAO;
import telephoneBook.Body.ConsoleHelper;
import telephoneBook.Body.book.Contact;

import java.util.List;

/**
 * Created by hatak on 2/3/17.
 */
public class SearchAction extends Action{
    @Override
    public void execute() {
        telephoneBook.Body.book.Book book = BookDAO.getInstance().getBook();
        String searched =ConsoleHelper.readConsole();
        List<Contact> allContacts = book.getAllContacts();
        for (Contact contact : allContacts) {
            if (contact.getName().contains(searched)){
                System.out.println(contact.toString());
            }
            if (contact.getSureName().contains(searched)){
                System.out.println(contact.toString());
            }

        }
    }
}
