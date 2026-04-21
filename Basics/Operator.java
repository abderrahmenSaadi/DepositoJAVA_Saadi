import java.util.Scanner;
import java.util.Scanner;
public class Operator {
    public static void main(String[] args) {
        int a ;
        int b  ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number: "); 
        a = sc.nextInt();
        System.out.println("Enter second number: ");
        b = sc.nextInt();
        sc.close();

        // Relational Operators
        System.out.println("a == b: " + (a == b)); // Equal to
        System.out.println("a != b: " + (a != b)); // Not equal to
        System.out.println("a > b: " + (a > b));   // Greater than
        System.out.println("a < b: " + (a < b));   // Less than
        System.out.println("a >= b: " + (a >= b)); // Greater than or equal to
        System.out.println("a <= b: " + (a <= b)); // Less than or equal to

        // Logical Operators
        boolean x = true;
        boolean y = false;
        System.out.println("x && y: " + (x && y)); // Logical AND
        System.out.println("x || y: " + (x || y)); // Logical OR
        System.out.println("!x: " + (!x));         // Logical NOT
    if (a > b) {
        System.out.println("a is greater than b");
    } else if (a < b) {
        System.out.println("a is less than b");
    } else {
        System.out.println("a is equal to b");
    }
    
    }

}
