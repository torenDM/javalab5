package ru.demidov.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class GenericMethods {
    public static <T, P> List<P> map(List<T> list, Function<T, P> mapper) {
        List<P> result = new ArrayList<>();
        for (T item : list) {
            result.add(mapper.apply(item));
        }
        return result;
    }
}
