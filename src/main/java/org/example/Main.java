package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = 500;
        List<String> result = sequence(n);
        System.out.println(result);


        String string = "make install";
        String reversed = reverse(string);
        System.out.println(reversed);


        float a = scanner.nextFloat();
        float b = scanner.nextFloat();
        float c = scanner.nextFloat();

        float[] roots = root(a, b, c);

        if (roots == null) {
            System.out.println("нет вещественных корней");
        } else
            System.out.println(roots[0] + " " + roots[1]);


        System.out.println("Сумма ряда равна " + sequenceSum());

        string = scanner.next();
        reversed = reverse(string);
        System.out.println("Проверка на палиндром " + string.equals(reversed));
    }

    public static double sequenceSum() {
        double member = 1;
        double sum = 0;

        for (int n = 2; member > 0.000001; n++) {
            member = 1.0 / (n * n + n - 2);
            sum += member;
        }
        return sum;
    }


    public static float[] root(float a, float b, float c) {
        float D = b * b - 4 * a * c;

        if (D >= 0) {
            float x1 = (float) ((-b - sqrt(D)) / (2 * a));
            float x2 = (float) ((-b + sqrt(D)) / (2 * a));
            return new float[]{x1, x2};
        } else
            return null;
    }

    public static String reverse(String str) {
        StringBuilder reversed = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    public static List<String> sequence(int n) {
        if (n <= 0)
            return null;

        List<String> sequence = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0) {
                if (i % 7 == 0)
                    sequence.add("fizzbuzz");
                else
                    sequence.add("fizz");
            } else if (i % 7 == 0) {
                sequence.add("buzz");
            } else
                sequence.add(String.valueOf(i));
        }

        return sequence;
    }
}



