public class functionExercices {
    public static void main(String[] args) {
        int result = add(5, 3);
        System.out.println("The sum of 5 and 3 is: " + result);
        int product1 = multiply(4, 6);
        System.out.println("The product of 4 and 6 is: " + product1);
        double product2 = multiply(2.0, 3.5);   
        System.out.println("The product of 2.5 and 3.5 is: " + product2);
        int sum = sumUpTo(6);
        System.out.println("The sum of numbers from 1 to 5 is: " + sum);
        int x = 10;
        System.out.println("Before passByValue method, x is: " + x);
        passByValue(x);
        System.out.println("After passByValue method, x is: " + x);
        int[] arr = {1, 2, 3};
        System.out.println("Before passByReference method, arr is: " + java.util.Arrays.toString(arr)   );
        passByReference(arr);
        System.out.println("After passByReference method, arr is: " + java.util.Arrays.toString(arr));
    }

    public static int add(int a, int b) {
        return a + b;
    }
    // This an overloading to muliply two numbers or integers
    public static int multiply(int a, int b) {
        return a * b;
    }
    public static double multiply(double a, double b) {
        return a * b;
    }
    // this methode take an integer and sum all the numbers from 1 to that integer
    public static int sumUpTo(int n) {
        if (n <= 0) {
            return 0;
        } else {
            return n + sumUpTo(n - 1);
        }

    }
    // this methodes shows the different between passing by value and passing by reference
    public static void passByValue(int x) {
        x = x + 5;
        System.out.println("Inside passByValue method: " + x);
    }
    
    public static void passByReference(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + 5;
            
        }
        System.out.println("Inside passByReference method: " + java.util.Arrays.toString(arr));
    }

    

}
