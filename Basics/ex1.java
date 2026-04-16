package Basics;
import java.util.Scanner;
public class ex1 {
    public static void main(String[] args) {
Scanner input = new Scanner(System.in);

        // Input dati
        System.out.print("Inserisci la tua età: ");
        int eta = input.nextInt();

        System.out.print("Hai un biglietto valido? (true/false): ");
        boolean biglietto = input.nextBoolean();

        System.out.print("Sei accompagnato da un adulto? (true/false): ");
        boolean accompagnato = input.nextBoolean();

        System.out.print("Hai acquistato il 'Salta la fila'? (true/false): ");
        boolean saltaFila = input.nextBoolean();

        // Controlli
        if (!biglietto) {
            System.out.println("Accesso negato: devi avere un biglietto valido.");
        } else {
            if (eta < 14 && !accompagnato) {
                System.out.println("Accesso negato: i minori di 14 anni devono essere accompagnati.");
            } else {
                if (saltaFila) {
                    System.out.println("Accesso consentito: puoi saltare la fila!");
                } else {
                    System.out.println("Accesso consentito: entra normalmente.");
                }
            }
        }

        input.close();
    }
    
}
