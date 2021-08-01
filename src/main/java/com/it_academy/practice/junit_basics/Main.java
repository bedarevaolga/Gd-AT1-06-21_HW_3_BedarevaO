package com.it_academy.practice.junit_basics;

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

        Calculator calc = new Calculator(10, 2, 1, 3, 1);

        System.out.println("Plus result: " +  calc.calculateMoreParameters('+'));
        System.out.println("Minus result: " +  calc.calculateMoreParameters('-'));
        System.out.println("Division result: " +  calc.calculateMoreParameters('/'));
        System.out.println("Multiply result: " +  calc.calculateMoreParameters('*'));

    }
}
