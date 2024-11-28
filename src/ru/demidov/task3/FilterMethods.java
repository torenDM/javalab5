package ru.demidov.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterMethods {
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}
