package ru.demidov.task6;

import java.util.LinkedList;
import java.util.Queue;

public class QueueBuilder {

    public static Queue<Integer> buildQueueFromList(int[] list) {
        // Создаем очередь
        Queue<Integer> queue = new LinkedList<>();

        // Добавляем элементы из списка в очередь
        for (int element : list) {
            queue.offer(element);
        }

        // Добавляем элементы из списка в обратном порядке
        for (int i = list.length - 1; i >= 0; i--) {
            queue.offer(list[i]);
        }

        return queue;
    }

    public static void printQueue(Queue<Integer> queue) {
        // Печатаем элементы очереди
        for (Integer element : queue) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}