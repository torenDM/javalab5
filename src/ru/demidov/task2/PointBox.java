package ru.demidov.task2;

import ru.demidov.task1.Box;

public class PointBox {
    // Метод для добавления трехмерной точки в коробку
    public static <T extends Point3D> void addPointToBox(Box<T> box, T point) {
        box.put(point);
    }
}
