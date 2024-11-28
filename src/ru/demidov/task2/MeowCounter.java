package ru.demidov.task2;

public class MeowCounter {

    public static void countMeows(Meowable... meowables) {
        for (Meowable meowable : meowables) {
            meowable.meow();
        }
    }
}