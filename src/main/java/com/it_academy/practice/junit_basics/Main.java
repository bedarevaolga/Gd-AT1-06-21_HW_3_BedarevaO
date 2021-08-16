package com.it_academy.practice.junit_basics;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n1 = Integer.parseInt(sc.next());
        int n2 = Integer.parseInt(sc.next());

        Calculator calculator = new Calculator(n1, n2);

        System.out.println("Plus result: " + calculator.calculate('+'));
        System.out.println("Minus result: " + calculator.calculate('-'));
        System.out.println("Division result: " + calculator.calculate('/'));
        System.out.println("Multiply result: " + calculator.calculate('*'));
        System.out.println("Exponentiation result: " + calculator.calculate('^'));
        System.out.println("Extracting the root result: " + calculator.calculate('√'));

        sc.close();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку чисел");

        ArrayList<Integer> list = new ArrayList<>();
        String lineOfNumbers = scanner.nextLine();
        String[] numbers = lineOfNumbers.split("\\s+");
        for (String number : numbers) {
            try {
                int x = Integer.parseInt(number);
                list.add(x);
            } catch (NumberFormatException e) {
                System.out.println("Введено недопустимое значение, начните сначала");
                return;
            }
        }
        scanner.close();

        Calculator calc = new Calculator(list);
        System.out.println(calc.calculateMoreParameters('-'));
        System.out.println(calc.calculateMoreParameters('+'));
        System.out.println(calc.calculateMoreParameters('*'));
        System.out.println(calc.calculateMoreParameters('/'));
    }
}
