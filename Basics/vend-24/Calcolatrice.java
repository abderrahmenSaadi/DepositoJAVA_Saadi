public class Calcolatrice {

    public int somma(int a, int b) {
        return a + b;
    }

    public int somma(int a, int b, int c) {
        return a + b + c;
    }

    public double somma(double a, double b) {
        return a + b;
    }

    /*
     This is an example of method overloading because the methods have the same name
     (somma) but differ in the number or type of parameters. It is not overriding
     because all methods are defined within the same class, not in a subclass.
    */
}