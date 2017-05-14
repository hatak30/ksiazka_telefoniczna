package telephoneBook.Body.actions;

import telephoneBook.Body.BookDAO;
import telephoneBook.Body.ConsoleHelper;
import telephoneBook.Body.book.Book;
import telephoneBook.Body.book.Contact;

import java.util.List;

/**
 * Created by hatak on 2/3/17.
 */
public class ViewAction extends Action{
    @Override
    public void execute() {
        Book book = BookDAO.getInstance().getBook();
        List<Contact> allContacts = book.getAllContacts();
        for (Contact contact : allContacts) {
            ConsoleHelper.printConsoleLn(contact+"");

        }

    }
}
