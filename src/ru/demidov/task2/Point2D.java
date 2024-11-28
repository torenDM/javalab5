package ru.demidov.task2;

public class Point2D {
    private final double x; // Координата X
    private final double y; // Координата Y

    // Конструктор для инициализации координат
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Метод для получения текстового представления точки
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    // Геттеры для координат (если нужно)
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Сравнение ссылок
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Проверка на null и на принадлежность к классу
        }
        Point2D other = (Point2D) obj; // Приведение типа
        return Double.compare(this.x, other.x) == 0 && Double.compare(this.y, other.y) == 0; // Сравнение координат
    }
}
