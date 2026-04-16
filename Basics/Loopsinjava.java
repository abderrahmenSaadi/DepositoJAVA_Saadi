package Basics;
import java.util.Scanner;

public class Loopsinjava {
    public static void main(String[] args) {
        int i = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        while (i < 5) {
            System.out.println("The value of i is: " + i);
            i++;
        }
        do {
        System.out.println("Enter a number: ");
         n = sc.nextInt();
            
        } while (n < 5);

    }
    
}
