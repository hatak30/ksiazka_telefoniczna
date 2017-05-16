package telephoneBook.body;

import java.util.Scanner;

/**
 * Created by hatak on 2/3/17.
 */
public class ConsoleHelper {
    public static String readConsole() {
        return new Scanner(System.in).nextLine();
    }

    public static void printConsoleLn(final String data) {
        System.out.println(data);
    }

    public static void printConsole(final String data) {
        System.out.print(data);
    }
}
