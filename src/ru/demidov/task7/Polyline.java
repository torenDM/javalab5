package ru.demidov.task7;

import java.util.List;
import java.util.stream.Collectors;

public class Polyline {
    private final List<Point> points;

    public Polyline(List<Point> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Линия: " + points.stream()
                .map(Point::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}