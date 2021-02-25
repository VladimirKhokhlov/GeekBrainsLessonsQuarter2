package lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Phonebook {
    static List<String[]> phoneBook = new ArrayList<>();

    public static void main(String[] args) {
        add("Хохлов", "+1");
        add("Хохлов", "+22");
        add("Хохлов", "+333");
        add("Петров", "+9999");
        add("Петров", "+8888");
        get("Петров");
        get("Хохлов");
    }

    public static void add(String lastName, String number) {
        for (String[] contact : phoneBook) {
            if (lastName.equals(contact[0])){
                phoneBook.lastIndexOf(number);
            }
        }
        phoneBook.add(new String[] {lastName,number});
    }

    public static void get(String lastName) {
        for (String[] contact : phoneBook) {
            if (lastName.equals(contact[0]))
            System.out.println(Arrays.toString(contact));
        }
    }
}
