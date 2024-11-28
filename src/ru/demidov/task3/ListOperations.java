package ru.demidov.task3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListOperations {
    public static <T> List<T> getIntersection(List<T> list1, List<T> list2) {
        Set<T> set1 = new HashSet<>(list1);
        Set<T> set2 = new HashSet<>(list2);

        set1.retainAll(set2);

        return new ArrayList<>(set1);
    }
}