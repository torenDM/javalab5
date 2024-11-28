package ru.demidov.task5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class LetterCounter {

    public static void countDistinctLetters(String filePath) {
        // Множество для хранения уникальных букв
        Set<Character> uniqueLetters = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Проходим по каждому символу в строке
                for (char c : line.toCharArray()) {
                    // Проверяем, является ли символ буквой русского алфавита
                    if (isRussianLetter(c)) {
                        uniqueLetters.add(Character.toLowerCase(c));  // Добавляем в Set в нижнем регистре
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Выводим количество уникальных букв
        System.out.println("Количество различных букв: " + uniqueLetters.size());
    }

    // Метод для проверки, является ли символ буквой русского алфавита
    private static boolean isRussianLetter(char c) {
        // Проверка на диапазоны для букв русского алфавита
        return (c >= 'А' && c <= 'Я') || (c >= 'а' && c <= 'я');
    }
}