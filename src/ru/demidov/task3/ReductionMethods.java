package ru.demidov.task3;

import java.util.List;
import java.util.function.BinaryOperator;

public class ReductionMethods {

    // Обобщенный метод для сокращения списка к одному значению
    public static <T> T reduce(List<T> values, BinaryOperator<T> accumulator) {
        // Если список пуст, возвращаем значение по умолчанию для типа T
        if (values == null || values.isEmpty()) {
            return null; // или можно вернуть значение по умолчанию для T
        }

        T result = values.getFirst();
        for (int i = 1; i < values.size(); i++) {
            result = accumulator.apply(result, values.get(i));
        }
        return result;
    }
}