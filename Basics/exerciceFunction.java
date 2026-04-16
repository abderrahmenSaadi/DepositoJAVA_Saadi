package Basics;
//import java.util.Scanner;

public class exerciceFunction {
    public static void main(String[] args) {
        int number = 5;
        int result = recursion(number);
        String str = "Hello, World!";
        recursion(str);
        System.out.println("Factorial of " + number + " is: " + result);
        System.out.println("Fibonacci of " + number + " is: " + fibonacci(number));
        
    }
    // Recursive method to calculate factorial of a number
    public static int recursion(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * recursion(n - 1);
        }
    }
    // Method if the input is a string, it will prompt the user to enter an integer
    public static void recursion(String str){
        System.out.println("please enter a integer: ");
        }
            static int fibonacci(int n) {
        // Caso base
        if (n == 0) return 0;
        if (n == 1) return 1;

        // Chiamata ricorsiva
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}
