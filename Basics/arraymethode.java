import java.util.Arrays;
public class arraymethode {
    public static void main(String[] args) {
        
        int[] numbers = {5, 3, 8, 1, 2};
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve"};
        Arrays.sort(numbers);
        Arrays.sort(names);
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
        for (String name : names) {
            System.out.print(name + " ");
        }
        boolean arraysEqual = Arrays.equals(numbers, new int[]{1, 2, 3, 5, 5});
        System.out.println("\nAre the two arrays equal? " + arraysEqual);


    }
    
}
