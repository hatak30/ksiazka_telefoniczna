package telephoneBook.body;

import telephoneBook.body.book.Book;

import java.io.*;

/**
 * Created by krzysiek on 22.01.17.
 */
public class BookDAO {

    private final File file = new File("Document");
    private Book book;
    private static BookDAO instance = null;

    public static BookDAO getInstance() {
        if (instance == null) {
            instance = new BookDAO();
        }
        return instance;
    }

    private BookDAO() {
        if (!file.exists()) {
            book = new Book();
            saveObjectAtfile(file, book);
        } else {
            book = (Book) readObjectFromFile(file);

        }
    }

    public static Object readObjectFromFile(File file) {
        try {
            InputStream in = new FileInputStream(file);
            ObjectInputStream objectIn = new ObjectInputStream(in);
            Object obj = objectIn.readObject();

            objectIn.close();
            in.close();
            return obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveObjectAtfile(File file, Object object) {
        try {
            OutputStream out = new FileOutputStream(file);
            ObjectOutputStream objektOut = new ObjectOutputStream(out);
            objektOut.writeObject(object);

            objektOut.close();
            objektOut.flush();
            out.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Book getBook() {
        return book;
    }

    public void save() {
        saveObjectAtfile(file, book);
    }
}
