package ru.demidov.task4;

import java.util.HashMap;
import java.util.Map;

public class FuelPriceMonitor {

    public static void monitorFuelPrices(int N, String[] inputData) {
        // Словарь для хранения минимальных цен для каждой марки бензина
        Map<String, Integer> minPrices = new HashMap<>();
        // Словарь для подсчета количества АЗС с минимальной ценой для каждой марки
        Map<String, Integer> countMinPriceStations = new HashMap<>();

        // Инициализация карт с максимальными возможными значениями
        minPrices.put("92", Integer.MAX_VALUE);
        minPrices.put("95", Integer.MAX_VALUE);
        minPrices.put("98", Integer.MAX_VALUE);

        countMinPriceStations.put("92", 0);
        countMinPriceStations.put("95", 0);
        countMinPriceStations.put("98", 0);

        // Обрабатываем каждую строку с данными
        for (String data : inputData) {
            String[] parts = data.split(" ");
            String company = parts[0];
            String street = parts[1];
            String fuelType = parts[2];
            int price = Integer.parseInt(parts[3]);

            // Обновляем минимальную цену для соответствующего типа бензина
            if (price < minPrices.get(fuelType)) {
                minPrices.put(fuelType, price);
                countMinPriceStations.put(fuelType, 1); // Перезаписываем на 1, так как нашли более дешевую цену
            } else if (price == minPrices.get(fuelType)) {
                countMinPriceStations.put(fuelType, countMinPriceStations.get(fuelType) + 1); // Увеличиваем счетчик
            }
        }

        // Выводим результат для каждой марки бензина
        System.out.println(countMinPriceStations.get("92") + " " + countMinPriceStations.get("95") + " " + countMinPriceStations.get("98"));
    }
}