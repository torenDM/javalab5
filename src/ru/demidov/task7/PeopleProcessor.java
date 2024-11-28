package ru.demidov.task7;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class PeopleProcessor {
    public static Map<Integer, List<String>> processPeopleFile(Path filePath) throws Exception {
        try (var lines = Files.lines(filePath)) {
            return lines
                    .map(line -> line.split(":")) // Разделяем строку по двоеточию
                    .filter(parts -> parts.length == 2 && !parts[1].isBlank()) // Убираем строки без номера
                    .collect(Collectors.groupingBy(
                            parts -> Integer.parseInt(parts[1].trim()), // Группируем по номеру
                            Collectors.mapping(
                                    parts -> capitalize(parts[0].trim()), // Форматируем имя
                                    Collectors.toList()
                            )
                    ));
        }
    }

    private static String capitalize(String name) {
        if (name == null || name.isEmpty()) return name;
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}