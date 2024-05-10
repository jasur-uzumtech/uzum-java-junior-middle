package org.uzum.iggytoto.javacore_synchronization;

import java.util.concurrent.Phaser;

public class Washer {
    public static void main (String[] args) {
        Phaser phaser = new Phaser(2);
        new WasherMan(phaser);
        new WasherMan(phaser);
    }

    static class WasherMan extends Thread {
        Phaser phaser;

        public WasherMan(Phaser phaser) {
            this.phaser = phaser;
            start();
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println(getName() + " washing #" + i + " car");
                phaser.arriveAndAwaitAdvance();
                System.out.println("phase#" + phaser.getPhase() + " " + getName());
            }
        }
    }
}
