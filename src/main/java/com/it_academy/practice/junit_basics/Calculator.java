package com.it_academy.practice.junit_basics;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private int a;
    private int b;
    private List<Integer> list = new ArrayList<>();

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Calculator(List<Integer> list) {
        this.list = list;
    }

    public float getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public float calculate(char operation) {
        switch (operation) {
            default: {
                return 0;
            }
            case '-': {
                return a - b;
            }
            case '+': {
                return a + b;
            }
            case '/': {
                try {
                    return (float) a / b;
                } catch (ArithmeticException e) {
                    System.out.println("Made arithmetic mistake:" + e.getMessage());
                }
            }
            case '*': {
                return a * b;
            }
            case '^': {
                return (float) Math.pow(a, b);
            }
            case '√': {
                if (b != 0) {
                    if (a >= 0) {
                        return (float) Math.pow(a, 1.0 / b);
                    }
                    if (a < 0 && b % 2 == 1) {
                        return (float) -Math.pow(-a, 1.0 / b);
                    } else {
                        System.out.println("Нельзя извлечь корень четной степени из отрицательного числа");
                        return 0;
                    }
                } else {
                    System.out.println("Нельзя извлечь корень нулевой степени");
                    return 0;
                }
            }
        }
    }

    public float calculateMoreParameters(char operation) {
        if (list.size() >= 2) {
            switch (operation) {
                default -> {
                    return 0;
                }
                case '-' -> {
                    float minus = list.get(0);
                    for (int i = 1; i < list.size(); i++) {
                        minus = minus - list.get(i);
                    }
                    return minus;
                }
                case '+' -> {
                    float plus = list.get(0);
                    for (int i = 1; i < list.size(); i++) {
                        plus = plus + list.get(i);
                    }
                    return plus;
                }
                case '/' -> {
                    float division = list.get(0);
                    for (int i = 1; i < list.size(); i++) {
                        if (list.get(i) != 0) {
                            division = division / list.get(i);
                        } else {
                            System.out.println("Arithmetic mistake");
                            return 0;
                        }
                    }
                    return division;
                }
                case '*' -> {
                    float multiply = list.get(0);
                    for (int i = 1; i < list.size(); i++) {
                        multiply = multiply * list.get(i);
                    }
                    return multiply;
                }
            }
        }
        return 0;
    }
}

