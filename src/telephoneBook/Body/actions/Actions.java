package telephoneBook.Body.actions;

import telephoneBook.Body.ConsoleHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by krzysiek on 08.01.17.
 */
public class Actions {

    List<Action> actions = new ArrayList<>();

    private Actions(){
        actions.add(new AddAction());
        actions.add(new RemoveAction());
        actions.add(new ViewAction());
        actions.add(new EditAction());
        actions.add(new SearchAction());
        actions.add(new EndAction());
    }

    public static Actions createActions(){
        return new Actions();
    }

    public void printActions() {
        ConsoleHelper.printConsoleLn("Select action: ");
        actions.stream().forEach(action -> ConsoleHelper.printConsoleLn("\t" + (actions.indexOf(action) +1) + ": " + action.getName()));
    }

    public Optional<Action> getSelectedAction(String actionName) {
        return actions.stream()
                .filter(action -> action.getName().equalsIgnoreCase(actionName) || actionName.equals(String.valueOf(actions.indexOf(action) + 1)))
                .findFirst();
    }
}