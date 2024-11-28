package ru.demidov.task2;

// Производный класс для представления трехмерной точки
public class Point3D extends Point2D {
    private final double z; // Координата Z

    // Конструктор для инициализации координат X, Y и Z
    public Point3D(double x, double y, double z) {
        super(x, y); // Вызов конструктора базового класса
        this.z = z;
    }

    // Переопределение метода toString() для трехмерной точки
    @Override
    public String toString() {
        return "{" + getX() + ";" + getY() + ";" + z + "}";
    }

    // Геттер для координаты Z (если нужно)
    public double getZ() {
        return z;
    }
}
