package telephoneBook.Body.book;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by krzysiek on 08.01.17.
 */
public class Contact implements Serializable{

    public static long serialVersionUID = 78437628;

    private String name;
    private String sureName;
    List<String> numbers = new ArrayList<>();

    public Contact(String name, String sureName, String number) {
        this.name = name;
        this.sureName = sureName;
        this.numbers.add(number);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name ='" + name + '\'' +
                ", sureName ='" + sureName + '\'' +
                ", numbers= " + numbers +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public void addNumber(final String number){
        this.numbers.add(number);
    }
}
