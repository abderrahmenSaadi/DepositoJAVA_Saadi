package Basics;
import java.util.ArrayList;

public class arraylistexp {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        System.out.println("Names: " + names);
        System.out.println("Size of list: " + names.size());
        System.out.println("Element at index 1: " + names.get(1));
        names.remove(0);
        System.out.println("Names after removal: " + names);
        
    }
    
}
