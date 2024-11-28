package ru.demidov.task3;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectionMethods {

    public static <T, P extends Collection<T>> Map<Boolean, P> partitionCollection(
            List<T> sourceList,
            Function<List<T>, P> collectionFactory,
            Predicate<T> predicate) {

        // Разделяем исходный список на две части по заданному предикату
        List<T> positiveList = sourceList.stream()
                .filter(predicate)
                .collect(Collectors.toList());

        List<T> negativeList = sourceList.stream()
                .filter(predicate.negate())
                .collect(Collectors.toList());

        // Создаем результирующие коллекции
        P positiveCollection = collectionFactory.apply(positiveList);
        P negativeCollection = collectionFactory.apply(negativeList);

        return Map.of(true, positiveCollection, false, negativeCollection);
    }



    public static <T, P extends Collection<T>> Map<Integer, P> groupByLength(
            List<T> sourceList,
            Function<List<T>, P> collectionFactory) {

        // Группируем строки по их длине
        return sourceList.stream()
                .collect(Collectors.groupingBy(
                        item -> item.toString().length(), // Получаем длину строки
                        Collectors.mapping(Function.identity(), Collectors.toList())
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> collectionFactory.apply(entry.getValue())
                ));
    }
}