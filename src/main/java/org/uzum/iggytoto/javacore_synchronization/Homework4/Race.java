package org.uzum.iggytoto.javacore_synchronization.Homework4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

public class Race {
    private static final Phaser START_LINE_PHASER = new Phaser(1);
    private static final Phaser PHASER = new Phaser();

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, (int) (Math.random() * 100 + 50)));
        cars.add(new Car(2, (int) (Math.random() * 100 + 50)));
        cars.add(new Car(3, (int) (Math.random() * 100 + 50)));
        cars.add(new Car(4, (int) (Math.random() * 100 + 50)));
        cars.add(new Car(5, (int) (Math.random() * 100 + 50)));

        for (Car car : cars) {
            car.start();
        }

        START_LINE_PHASER.arriveAndAwaitAdvance(); // Ждем, пока все подъедут к стартовой прямой
        System.out.println("На старт!");
        System.out.println("Внимание!");
        System.out.println("Марш!");

        // Ожидаем завершения гонки всех машин
        PHASER.register(); // Регистрируем главный поток
        PHASER.arriveAndAwaitAdvance(); // Ждем, пока все машины финишируют
        PHASER.arriveAndDeregister(); // Снимаем регистрацию главного потока
    }

    static class Car extends Thread {
        private int carNumber;
        private int carSpeed;

        public Car(int carNumber, int carSpeed) {
            this.carNumber = carNumber;
            this.carSpeed = carSpeed;
        }

        public int getCarNumber() {
            return carNumber;
        }

        public int getCarSpeed() {
            return carSpeed;
        }

        @Override
        public void run() {
            System.out.println("Автомобиль №" + this.getCarNumber() + " подъехал к стартовой прямой.");
            START_LINE_PHASER.arriveAndAwaitAdvance(); // Ожидаем начала гонки

            // Симуляция гонки
            try {
                Thread.sleep(1000 * 100 / this.getCarSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Автомобиль №" + this.getCarNumber() + " финишировал!");
            PHASER.arrive(); // Сообщаем о завершении гонки
        }
    }
}
