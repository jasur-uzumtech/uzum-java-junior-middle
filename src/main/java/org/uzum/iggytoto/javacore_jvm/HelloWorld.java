package org.uzum.iggytoto.javacore_jvm;
import java.util.stream.IntStream;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("simple for loop:");
        for (int i = 0; i <= 10; i++) {
            if (i == 5) {
                continue;
            }
            System.out.println(i);
        }

        System.out.println("python loop:");
        int[] numbers = IntStream.range(0, 11).toArray();
        for (int num : numbers) {
            if (num == 5) {
                continue;
            }
            System.out.println(num);
        }

        System.out.println("while loop:");
        int i = 0;
        while (i <= 10) {
            if (i == 5) {
                i ++;
                continue;
            }
            System.out.println(i);
            i ++;
        }

        System.out.println("do while loop:");
        i = 0;
        do {
            if (i == 5) {
                i ++;
                continue;
            }
            System.out.println(i);
            i++;
        } while (i <= 10);
    }
}
