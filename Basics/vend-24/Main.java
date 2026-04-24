
public class Main {
    public static void main(String[] args) {
        Veicolo v1 = new Veicolo("Mercesdes", 120);
        Auto a1 = new Auto("Fiat", 180, 4);

        System.out.println("Veicolo:");
        v1.descrivi();

        System.out.println("\nAuto:");
        a1.descrivi();
        Calcolatrice calc = new Calcolatrice();
        System.out.println("\nCalcolatrice:");
        System.out.println("Somma di 5 e 10: " + calc.somma(5, 10));
        System.out.println("Somma di 5, 10 e 15: " +    calc.somma(5, 10, 15));
        System.out.println("Somma di 5.5 e 10.5: "  + calc.somma(5.5, 10.5));
    }

    
}
