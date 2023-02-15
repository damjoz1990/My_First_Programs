/**
 * This program calculates the result of a simple arithmetic operation between two numbers entered by the user.
 * The user has to enter two numbers and an operator (+, -, *, /) and the program will calculate the result of that operation.
 * If the user enters an invalid operator, the program will display an error message.
 */

import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2, result;
        char operator;

        System.out.println("Enter the first number: ");
        num1 = scanner.nextDouble();
        System.out.println("Enter the second number: ");
        num2 = scanner.nextDouble();
        System.out.println("Enter the operator (+, -, *, /): ");
        operator = scanner.next().charAt(0);

        switch(operator) {
            case '+':
                result = num1 + num2;
                System.out.println("Result: " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println("Result: " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println("Result: " + result);
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Error: division by zero");
                } else {
                    result = num1 / num2;
                    System.out.println("Result: " + result);
                }
                break;
            default:
                System.out.println("Error: invalid operator");
        }
        scanner.close();
    }
}
