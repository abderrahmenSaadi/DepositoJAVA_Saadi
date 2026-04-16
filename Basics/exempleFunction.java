package Basics;
public class exempleFunction {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        int sum = add(a, b);
        System.out.println("The sum of " + a + " and " + b + " is: " + sum);
        aff(sum);
        aff("buongiorno");


        
    }
    // This method takes two integers as parameters and returns their sum.
    public static int add(int x, int y) {
        return x + y;
    }
    // This method takes an integer as a parameter and prints it to the console.
    public static void aff(int x) {
        System.out.println("The number is: " + x );
    }
    // methode with same name but different parameters (overloading)
    public static void aff(String message) {
        System.out.println("The message is: " + message);
    }

}
