import java.util.Scanner;

public class exercicefor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  i = 0;
        System.out.println("Enter a number: "); 

        int n = sc.nextInt();
        sc.close();
        for (i = 0; i < 11; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
    }
}
