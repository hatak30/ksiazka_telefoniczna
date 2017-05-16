package telephoneBook.body.actions;

import telephoneBook.body.BookDAO;
import telephoneBook.body.ConsoleHelper;
import telephoneBook.body.book.Book;
import telephoneBook.body.book.Contact;

import java.util.List;

/**
 * Created by hatak on 2/3/17.
 */
public class ViewAction extends Action {
    @Override
    public void execute() {
        Book book = BookDAO.getInstance().getBook();
        List<Contact> allContacts = book.getAllContacts();
        for (Contact contact : allContacts) {
            ConsoleHelper.printConsoleLn(contact + "");
        }
    }
}
