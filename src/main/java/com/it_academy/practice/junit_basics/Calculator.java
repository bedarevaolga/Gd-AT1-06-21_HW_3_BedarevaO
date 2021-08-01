package com.it_academy.practice.junit_basics;

public class Calculator {

    private int a;
    private int b;
    private int c;
    private int d;
    private int e;

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Calculator(int a, int b, int c, int d, int e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
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

    public int getC() {
        return c;
    }

    public int getD() {
        return d;
    }

    public int getE() {
        return e;
    }

    public void setC(int c) {
        this.c = c;
    }

    public void setD(int d) {
        this.d = d;
    }

    public void setE(int e) {
        this.e = e;
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
                return a / b;
            }
            case '*': {
                return a * b;
            }
            case '^': {
                return (float) Math.pow(a, b);
            }
            case '√': {
                return (float) Math.exp(Math.log(a)/b);
            }

        }
    }

    public float calculateMoreParameters(char operation) {
        switch (operation) {
            default: {
                return 0;
            }
            case '-': {
                return a - b - c - d - e;
            }
            case '+': {
                return a + b + c + d + e;
            }
            case '/': {
                return a / b / c / d / e;
            }
            case '*': {
                return a * b * c * d * e;
            }
        }
    }
}

