package org.example;

import java.util.Scanner;

/**
 * Scientific Calculator
 * Supports: addition, subtraction, multiplication, division,
 * power, square root, natural logarithm, and factorial.
 */
public class Calculator {

    // ──────────────────── Core Operations ────────────────────

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Error! Division by zero.");
        }
        return a / b;
    }

    // ──────────────────── Advanced Operations ────────────────────

    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static double squareRoot(double num) {
        if (num < 0) {
            throw new ArithmeticException("Error! Square root of a negative number.");
        }
        return Math.sqrt(num);
    }

    public static double logarithm(double num) {
        if (num <= 0) {
            throw new ArithmeticException("Error! Logarithm of zero or negative number.");
        }
        return Math.log(num);
    }

    public static double factorial(double num) {
        if (num < 0) {
            throw new ArithmeticException("Error! Factorial of a negative number.");
        }
        double result = 1;
        for (int i = 2; i <= (int) num; i++) {
            result *= i;
        }
        return result;
    }

    // ──────────────────── Helpers ────────────────────

    private static void printMenu() {
        System.out.println("\n╔══════════════════════════╗");
        System.out.println("║    Scientific Calculator ║");
        System.out.println("╚══════════════════════════╝");
        System.out.println("  1. Addition        5. Power");
        System.out.println("  2. Subtraction     6. Square Root");
        System.out.println("  3. Multiplication  7. Logarithm (ln)");
        System.out.println("  4. Division        8. Factorial");
        System.out.println("  9. Exit");
        System.out.print("  Choice: ");
        System.out.flush();
    }

    private static double readTwoNumbers(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextDouble();
    }

    // ──────────────────── Main ────────────────────

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nStarting Scientific Calculator...");
        System.out.flush();

        while (true) {
            printMenu();
            int choice = sc.nextInt();

            if (choice == 9) {
                System.out.println("\nGoodbye!");
                break;
            }

            try {
                double a, b, result;
                switch (choice) {
                    case 1:
                        a = readTwoNumbers(sc, "Enter first number: ");
                        b = readTwoNumbers(sc, "Enter second number: ");
                        result = add(a, b);
                        System.out.printf("  %s + %s = %s%n", a, b, result);
                        break;

                    case 2:
                        a = readTwoNumbers(sc, "Enter first number: ");
                        b = readTwoNumbers(sc, "Enter second number: ");
                        result = subtract(a, b);
                        System.out.printf("  %s - %s = %s%n", a, b, result);
                        break;

                    case 3:
                        a = readTwoNumbers(sc, "Enter first number: ");
                        b = readTwoNumbers(sc, "Enter second number: ");
                        result = multiply(a, b);
                        System.out.printf("  %s × %s = %s%n", a, b, result);
                        break;

                    case 4:
                        a = readTwoNumbers(sc, "Enter dividend: ");
                        b = readTwoNumbers(sc, "Enter divisor: ");
                        result = divide(a, b);
                        System.out.printf("  %s ÷ %s = %s%n", a, b, result);
                        break;

                    case 5:
                        a = readTwoNumbers(sc, "Enter base: ");
                        b = readTwoNumbers(sc, "Enter exponent: ");
                        result = power(a, b);
                        System.out.printf("  %s ^ %s = %s%n", a, b, result);
                        break;

                    case 6:
                        a = readTwoNumbers(sc, "Enter number: ");
                        result = squareRoot(a);
                        System.out.printf("  √%s = %s%n", a, result);
                        break;

                    case 7:
                        a = readTwoNumbers(sc, "Enter number: ");
                        result = logarithm(a);
                        System.out.printf("  ln(%s) = %s%n", a, result);
                        break;

                    case 8:
                        a = readTwoNumbers(sc, "Enter number: ");
                        result = factorial(a);
                        System.out.printf("  %s! = %s%n", (int) a, result);
                        break;

                    default:
                        System.out.println("  Invalid option. Please choose 1–9.");
                }
            } catch (ArithmeticException e) {
                System.out.println("  ⚠ " + e.getMessage());
            }
        }

        sc.close();
    }
}
