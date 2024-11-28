package ru.demidov.main;

import ru.demidov.task1.Box;
import ru.demidov.task1.Storage;
import ru.demidov.task2.Point3D;
import ru.demidov.task3.CollectionMethods;
import ru.demidov.task3.FilterMethods;
import ru.demidov.task3.GenericMethods;
import ru.demidov.task3.ReductionMethods;

import java.util.*;

import static ru.demidov.task1.Storage.getValueFromStorage;
import static ru.demidov.task2.PointBox.addPointToBox;


// Основной класс для тестирования
public class Main {
    public static void main(String[] args) {
        // Задача 1.1: Обобщенная коробка
        try {
            System.out.println("\nЗадача 1.1: Обобщенная коробка");
            Box<Integer> integerBox = new Box<>();         // Создаем коробку, которая может хранить целочисленные значения
            integerBox.put(3);         // Размещаем число 3 в коробке
            Integer value = integerBox.get();         // Извлекаем значение из коробки
            System.out.println("Извлеченное значение: " + value);         // Выводим значение на экран
            System.out.println("Коробка пустая? " + integerBox.isEmpty());         // Проверяем, пустая ли коробка

            // Пробуем положить сразу два значения
            integerBox.put(3);
            integerBox.put(5); // Это должно вызвать исключение
        } catch (IllegalStateException e) {
            System.out.println("Перехваченная ошибка: " + e.getMessage());
        }

        // Задача 1.2: Без null
        System.out.println("\nЗадача 1.2: Без null");
        System.out.print("Хранилище чисел с <null>: ");
        Storage<Integer> numberStorageNull = new Storage<>(null);
        System.out.println(getValueFromStorage(numberStorageNull, 0)); // Ожидается 0

        System.out.print("Хранилище чисел с <99>: ");
        Storage<Integer> numberStorage99 = new Storage<>(99);
        System.out.println(getValueFromStorage(numberStorage99, -1)); // Ожидается 99

        System.out.print("Хранилище строк с <null>: ");
        Storage<String> stringStorageNull = new Storage<>(null);
        System.out.println(getValueFromStorage(stringStorageNull, "default")); // Ожидается "default"

        System.out.print("Хранилище строк с <hello>: ");
        Storage<String> stringStorageHello = new Storage<>("hello");
        System.out.println(getValueFromStorage(stringStorageHello, "hello world")); // Ожидается "hello"

        // Задача 2.3: Начало отсчета
        try {
            System.out.println("\nЗадача 2.3: Начало отсчета");
            Box<Point3D> pointBox = new Box<>();         // Создаем коробку для трехмерных точек
            Point3D point = new Point3D(1.0, 2.0, 3.0);         // Создаем трехмерную точку
            addPointToBox(pointBox, point);         // Добавляем точку в коробку
            System.out.println("Коробка: " + pointBox); // Проверяем содержимое коробки
            Point3D retrievedPoint = pointBox.get();         // Получаем точку из коробки и выводим ее
            System.out.print("Извлеченная точка: ");
            System.out.println(retrievedPoint); // Ожидается вывод: {1.0;2.0;3.0}

            Point3D point1 = new Point3D(1.0, 2.0, 3.0);
            addPointToBox(pointBox, point1);
            Point3D point2 = new Point3D(1.0, 2.0, 3.0);
            addPointToBox(pointBox, point2);
        } catch (IllegalStateException e) {
            System.out.println("Перехваченная ошибка: " + e.getMessage());
        }

        // Задача 3.1: Функция
        System.out.println("\nЗадача 3.1: Функция");

        // ч.1
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
        List<Integer> lengths = GenericMethods.map(strings, String::length);

        // ч.2
        System.out.println("1. Длина каждой строки: " + lengths);
        List<Integer> numbers = Arrays.asList(1, -3, 7);
        List<Integer> positiveNumbers = GenericMethods.map(numbers, Math::abs);

        // ч.3
        System.out.println("2. Положительные числа: " + positiveNumbers);
        List<int[]> arrays = Arrays.asList(new int[]{1, 2, 3}, new int[]{4, 5}, new int[]{-1, -2});
        List<Integer> maxValues = GenericMethods.map(arrays, arr -> Arrays.stream(arr).max().orElse(Integer.MIN_VALUE));
        System.out.println("3. Максимальные значения: " + maxValues);

        // Задача 3.2: Фильтр
        System.out.println("\nЗадача 3.2: Фильтр");

        // ч.1
        List<String> filteredStrings = FilterMethods.filter(strings, s -> s.length() >= 3);
        System.out.println("1. Фильтр - строки не менее 3 символов: " + filteredStrings);

        // ч.2
        List<Integer> filteredNumbers = FilterMethods.filter(numbers, n -> n < 0);
        System.out.println("2. Фильтр - только отрицательные значения: " + filteredNumbers);

        // ч.3
        List<int[]> filteredArrays = FilterMethods.filter(arrays, arr -> Arrays.stream(arr).noneMatch(n -> n > 0));
        System.out.print("3. Фильтр - только массивы исключительно с отрицательными числами: ");
        for (int[] array : filteredArrays) {
            System.out.println(Arrays.toString(array) + " ");
        }

        // Задача 3.3: Сокращение
        System.out.println("\nЗадача 3.3: Сокращение");

        // ч.1
        List<String> stringList = Arrays.asList("qwerty", "asdfg", "zx");
        String concatenatedString = ReductionMethods.reduce(stringList, String::concat);
        System.out.println("1. Сформированная строка: " + concatenatedString);

        // ч.2
        List<Integer> integerList = Arrays.asList(1, -3, 7);
        Integer sum = ReductionMethods.reduce(integerList, Integer::sum);
        System.out.println("2. Сумма значений: " + sum);

        // ч.3
        List<List<Integer>> listOfIntegerLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );
        List<Integer> totalList = new ArrayList<>(ReductionMethods.reduce(listOfIntegerLists, (list1, list2) -> {
            List<Integer> newList = new ArrayList<>(list1); // Создаем новый список
            newList.addAll(list2);
            return newList;
        }));
        int totalCount = totalList.size();
        System.out.println("3. Общее количество элементов во всех списках: " + totalCount);


        // Задача 3.4: Коллекционирование
        System.out.println("\nЗадача 3.4: Коллекционирование");

        // ч.1
        var partitionedNumbers = CollectionMethods.partitionCollection(
                numbers,
                ArrayList::new,
                number -> number > 0
        );
        System.out.println("1. Положительные числа: " + partitionedNumbers.get(true));
        System.out.println("1. Отрицательные числа: " + partitionedNumbers.get(false));

        // ч.2
        List<String> stringsSort = List.of("qwerty", "asdfg", "zx", "qw");
        Map<Integer, List<String>> groupedStrings = CollectionMethods.groupByLength(
                stringsSort,
                ArrayList::new
        );
        groupedStrings.forEach((length, group) ->
                System.out.println("2. Строки длиной " + length + ": " + group)
        );

        // ч.3
        List<String> uniqueStrings = List.of("qwerty", "asdfg", "qwerty", "qw");
        Set<String> uniqueSet = new HashSet<>(uniqueStrings);
        System.out.println("3. Уникальные строки: " + uniqueSet);
    }
}
