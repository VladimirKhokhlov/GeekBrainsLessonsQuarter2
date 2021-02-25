package lesson3;

import java.util.*;

public class Task1 {
    static String[] array = {"Путин","Водка","Балалайка","Бабушка","Матрёшка",
            "Чай","Водка","Хлеб","Селёдка","Путин",
            "Отвёртка","Дрель","Краска","Путин","Селёдка",
            "Яблоко","Путин","Стол","Водка","Матрёшка"};

    public static void main(String[] args) {
        Set<String> setArray = new HashSet<>(Arrays.asList(array));
        System.out.println(setArray); // Печатаем список уникальных слов

        List<String> list = Arrays.asList(array);
        for (String s : setArray) {
            System.out.println(s + ": " + Collections.frequency(list, s)); //Печатаем количество повторяющихся слов
        }
    }
}
