package org.uzum.iggytoto.javacore_synchronization;

import java.util.concurrent.Phaser;

public class BusExample {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1); // 1 to register the main thread

        // Create 5 passengers (threads)
        for (int i = 0; i < 5; i++) {
            new Passenger(phaser, "Passenger " + (i + 1)).start();
        }

        // Bus arrives
        System.out.println("Bus has arrived.");
        phaser.arriveAndDeregister(); // Bus deregisters, allowing passengers to board

        // Simulate bus journey
        try {
            Thread.sleep(1000); // Wait for the journey to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Bus reaches the destination
        System.out.println("Bus has reached the destination.");
        phaser.arriveAndAwaitAdvance(); // Wait for all passengers to reach the destination

        System.out.println("All passengers have reached the destination. Bus journey complete.");
    }

    static class Passenger extends Thread {
        private Phaser phaser;

        public Passenger(Phaser phaser, String name) {
            super(name);
            this.phaser = phaser;
            phaser.register(); // Register the passenger with the phaser
        }

        @Override
        public void run() {
            System.out.println(getName() + " has arrived at the bus stop.");
            phaser.arriveAndAwaitAdvance(); // Wait for the bus to arrive

            System.out.println(getName() + " has boarded the bus.");
            phaser.arriveAndAwaitAdvance(); // Wait for the bus journey to complete

            System.out.println(getName() + " has reached the destination.");
            phaser.arriveAndDeregister(); // Deregister the passenger from the phaser
        }
    }
}