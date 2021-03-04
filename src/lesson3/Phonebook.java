package lesson3;

import java.util.*;

public class Phonebook {
    static TreeMap<String, HashSet<String>> phoneBook = new TreeMap<>();

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
        if (phoneBook.containsKey(lastName)) {
            phoneBook.put(lastName, new HashSet<>());
        }
        phoneBook.get(lastName).add(number);
    }

    public static void get(String lastName) {
        if (phoneBook.containsKey(lastName))
            System.out.println(lastName + phoneBook.get(lastName));
    }
}
