package com.tutorial.telephonebook.actions;



import com.tutorial.telephonebook.BookDAO;
import com.tutorial.telephonebook.ConsoleHelper;
import com.tutorial.telephonebook.book.Book;
import com.tutorial.telephonebook.book.Contact;

import java.util.List;

/**
 * Created by hatak on 2/3/17.
 */
public class EditAction extends Action {

    @Override
    public void execute() {
        Book book = BookDAO.getInstance().getBook();
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
                String secendQuestion = ConsoleHelper.readConsole();
                if (secendQuestion.equalsIgnoreCase("y")) {
                    System.out.println("Enter a new surname");
                    String newSurname = ConsoleHelper.readConsole();
                    contact.setSureName(newSurname);
                }
                System.out.println("Earlier number/numbers: " + contact.getNumbers());
                // TODO: 2017-05-14 numberss
            }
        }

        if (editContact != null) {

        }
        BookDAO.getInstance().save();
    }
}