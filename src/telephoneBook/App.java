package telephoneBook;

import telephoneBook.body.ConsoleHelper;
import telephoneBook.body.actions.Action;
import telephoneBook.body.actions.Actions;
import telephoneBook.body.actions.EndAction;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by hatak on 2/3/17.
 */
public class App {
    public static void main(String args[]) throws IOException, ClassNotFoundException {

        Actions actions = Actions.createActions();

        boolean theEnd = true;
        do {
            actions.printActions();
            String menu = ConsoleHelper.readConsole();

            Optional<Action> selectedAction = actions.getSelectedAction(menu);
            if (selectedAction.isPresent()) {
                Action action = selectedAction.get();
                ConsoleHelper.printConsoleLn("selected "+ action.getName());
                action.execute();
                if(action instanceof EndAction){
                    theEnd = false;
                }
            }
        } while (theEnd);
    }
}
