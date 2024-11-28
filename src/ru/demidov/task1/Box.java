package ru.demidov.task1;

// Обобщенный класс Box
public class Box<T> {
    private T item;

    // Конструктор
    public Box() {
        this.item = null;
    }

    // Метод для размещения объекта в коробке
    public void put(T item) {
        if (this.item != null) {
            throw new IllegalStateException("Коробка уже заполнена!");
        }
        this.item = item;
    }

    // Метод для получения объекта из коробки
    public T get() {
        T tempItem = this.item;
        this.item = null; // Обнуляем ссылку на объект
        return tempItem;
    }

    // Метод проверки на заполненность
    public boolean isEmpty() {
        return this.item == null;
    }

    // Метод toString
    @Override
    public String toString() {
        return "Box{" + "item=" + item + '}';
    }
}