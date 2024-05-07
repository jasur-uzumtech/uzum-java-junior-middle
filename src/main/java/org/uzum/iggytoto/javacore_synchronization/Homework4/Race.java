package org.uzum.iggytoto.javacore_synchronization.Homework4;

import java.util.concurrent.Phaser;

public class Race {
    private static final Phaser PHASER = new Phaser(1); // Инициализируем Phaser с фазой 1 (главной фазой)

    private static final int THREAD_COUNT = 3; // Количество участников гонки

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(new Car(i)).start(); // Запускаем участников гонки
        }

        System.out.println("Ready to start the race!");
        PHASER.arrive(); // Уведомляем, что главная фаза завершена
        PHASER.awaitAdvance(0); // Ожидаем, пока все участники фазы завершатся
        System.out.println("Race is over!");
    }

    public static class Car implements Runnable {
        private final int carNumber;

        public Car(int carNumber) {
            this.carNumber = carNumber;
        }

        @Override
        public void run() {
            System.out.println("Car #" + carNumber + " is ready");
            PHASER.arriveAndAwaitAdvance(); // Ожидаем, пока все участники подготовятся к старту
            System.out.println("Car #" + carNumber + " started the race");
            PHASER.arriveAndDeregister(); // Уведомляем о завершении фазы и удаляем участника
        }
    }
}
