package ru.demidov.main;

import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import ru.demidov.task1.Fraction;
import ru.demidov.task2.Cat;
import ru.demidov.task2.MeowCounter;
import ru.demidov.task3.ListOperations;
import ru.demidov.task7.*;

import static ru.demidov.task4.FuelPriceMonitor.monitorFuelPrices;
import static ru.demidov.task5.LetterCounter.countDistinctLetters;
import static ru.demidov.task6.QueueBuilder.buildQueueFromList;
import static ru.demidov.task6.QueueBuilder.printQueue;

// Основной класс для тестирования
public class Main {
    public static void main(String[] args) {
        // Задача 1.1: Шаблоны
        System.out.println("\nЗадача 1.1: Шаблоны");
        Fraction fraction = new Fraction(3, -4);
        System.out.println("Щаблон: " + fraction);
        System.out.println("Значение: " + fraction.getValue());

        // Задача 2.1: Структурные шаблоны
        System.out.println("\nЗадача 2.1: Структурные шаблоны");
        Cat cat1 = new Cat("Барсик");
        Cat cat2 = new Cat("Том");

        MeowCounter.countMeows(cat1, cat2);

        System.out.println(cat1 + " мяукал " + cat1.getMeowCount() + " раз.");
        System.out.println(cat2 + " мяукал " + cat2.getMeowCount() + " раз.");


        // Задача 3.7: Структурные шаблоны
        System.out.println("\nЗадача 3.7: Список");
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);

        List<Integer> intersection = ListOperations.getIntersection(list1, list2);

        System.out.println("Пересечение двух списков: " + intersection);

        // Задача 4.7: Мап
        System.out.println("\nЗадача 4.7: Мап");
        String[] inputData = {
                "Синойл Цветочная 95 59",
                "Газпром Тверская 95 62",
                "Лукойл Московская 92 60",
                "Лукойл Цветочная 92 59",
                "Роснефть Пушкина 95 59",
                "Татнефть Ленина 95 55",
                "Газпром Ленина 98 65",
                "Татнефть Тверская 92 57",
                "Роснефть Ленина 92 62",
                "Синойл Ленина 95 55",
                "Газпром Ленина 92 59",
                "Лукойл Ленина 98 60"
        };

        int N = inputData.length;
        System.out.print("Ответ: ");
        monitorFuelPrices(N, inputData);

        // Задача 5.7: Сет
        System.out.println("\nЗадача 5.7: Сет");
        String filePath = "data/text.txt";
        countDistinctLetters(filePath);

        // Задача 6.2: Очередь
        System.out.println("\nЗадача 6.2: Очередь");
        int[] list = {1, 2, 3};
        Queue<Integer> resultQueue = buildQueueFromList(list);
        System.out.print("Очередь: ");
        printQueue(resultQueue);


        // Задание 7.1: Работа с Point и Polyline
        System.out.println("\nЗадание 7.1: Работа с Point и Polyline");
        List<Point> points = List.of(
                new Point(1, 2),
                new Point(3, -4),
                new Point(1, 2),
                new Point(-3, -4),
                new Point(5, -6)
        );

        Polyline polyline = points.stream()
                .distinct() // Убираем точки с одинаковыми координатами
                .map(p -> new Point(p.getX(), Math.abs(p.getY()))) // Преобразуем отрицательные Y в положительные
                .sorted(Comparator.comparingInt(Point::getX)) // Сортируем по X
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Polyline::new
                ));

        System.out.println(polyline);

        // Задание 7.2: Работа с текстовым файлом
        System.out.println("\nЗадание 7.2: Работа с текстовым файлом");
        Path streamPath = Path.of("data/people.txt");

        try {
            Map<Integer, List<String>> groupedPeople = PeopleProcessor.processPeopleFile(streamPath);
            System.out.println(groupedPeople);
        } catch (Exception e) {
            System.err.println("Ошибка при обработке файла: " + e.getMessage());
        }

    }
}
