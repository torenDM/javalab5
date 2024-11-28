package ru.demidov.task1;

// Обобщенный класс Storage
public class Storage<T> {
    private final T value;

    // Конструктор, принимающий значение
    public Storage(T value) {
        this.value = value;
    }

    // Метод для получения значения с альтернативным значением
    public T getValue(T alternativeValue) {
        return value != null ? value : alternativeValue;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "value=" + value +
                '}';
    }

    // Метод для извлечения значения из хранилища
    public static <T> T getValueFromStorage(Storage<T> storage, T alternativeValue) {
        return storage.getValue(alternativeValue);
    }
}


