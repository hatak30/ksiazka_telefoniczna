package telephoneBook.body.actions;

import telephoneBook.body.BookDAO;
import telephoneBook.body.ConsoleHelper;
import telephoneBook.body.book.Contact;

import java.util.List;

/**
 * Created by hatak on 2/3/17.
 */
public class EditAction extends Action {

    @Override
    public void execute() {
        telephoneBook.body.book.Book book = BookDAO.getInstance().getBook();
        List<Contact> allContacts = book.getAllContacts();
        for (Contact contact : allContacts) {
            ConsoleHelper.printConsoleLn(contact + "");
        }
        System.out.println("chose Contact name to edit");
        String searched = ConsoleHelper.readConsole();
        Contact editContact = null;
        for (Contact contact : allContacts) {
            if (searched.equalsIgnoreCase(contact.getName())) {

                System.out.println("Earlier name: " + contact.getName());
                System.out.println("do you won't change name?   (y/n)");
                String question = ConsoleHelper.readConsole();
                if (question.equalsIgnoreCase("y")) {
                    System.out.println("Enter a new name");
                    String newName = ConsoleHelper.readConsole();
                    contact.setName(newName);
                }

                System.out.println("Earlier surname: " + contact.getSureName());
                System.out.println("do you won't change surname?   (y/n)");
                String question_2 = ConsoleHelper.readConsole();
                if (question_2.equalsIgnoreCase("y")) {
                    System.out.println("Enter a new surname");
                    String newSurname = ConsoleHelper.readConsole();
                    contact.setSureName(newSurname);
                }

                // TODO: 2017-05-14 numbers
            }
        }

        if (editContact != null) {

        }
        BookDAO.getInstance().save();
    }
}