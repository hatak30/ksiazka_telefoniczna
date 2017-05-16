package telephoneBook.body.actions;

/**
 * Created by hatak on 2/3/17.
 */
public abstract class Action {

    public String getName() {
        String name = getClass().getSimpleName();
        return name.replace("Action", "");
    }

    public abstract void execute();
}
