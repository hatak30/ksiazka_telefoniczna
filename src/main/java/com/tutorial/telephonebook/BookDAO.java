package com.tutorial.telephonebook;


import com.sun.org.apache.xpath.internal.functions.FuncQname;
import com.tutorial.telephonebook.book.Book;
import com.tutorial.telephonebook.book.Contact;

import java.io.*;
import java.util.List;

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

    public Book getBook() {
        return book;
    }

    public void save() {
        saveObjectAtfile(file, book);
    }

    public static void saveObjectAtfile(File file, Object object) throws NullPointerException {

        String headTitle = "#imie|nazwisko|telefon1|telefon2|....|telefonN";
        String separator = "|";


        try (FileWriter fileWriter = new FileWriter("documentCSV.csv")) {

            Book book = BookDAO.getInstance().getBook();
            List<Contact> allContacts = book.getAllContacts();


            fileWriter.append(headTitle);
            System.out.println();
            for (Contact c : allContacts) {
                fileWriter.append("\n");
                fileWriter.append(c.getName());
                fileWriter.append(separator);
                fileWriter.append(c.getSureName());
                fileWriter.append(separator);
                //fileWriter.append(c.getNumbers());
                fileWriter.append(separator);
                System.out.println();
            }
            fileWriter.close();
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
/*
        try {
            OutputStream out = new FileOutputStream(file);
            ObjectOutputStream objektOut = new ObjectOutputStream(out);
            objektOut.writeObject(object);

            objektOut.close();
            objektOut.flush();
            out.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/


    }
}
