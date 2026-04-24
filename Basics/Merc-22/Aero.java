import java.util.ArrayList;
import java.util.Scanner;

// ================= AEREO =================
class Aereo {
    private String modello;
    private int numeroPosti;
    private String codice;

    public Aereo(String modello, int numeroPosti, String codice) {
        setModello(modello);
        setNumeroPosti(numeroPosti);
        setCodice(codice);
    }

    public String getModello() { return modello; }

    public void setModello(String modello) {
        if (modello != null && !modello.trim().isEmpty()) {
            this.modello = modello;
        } else {
            System.out.println("Invalid model.");
        }
    }

    public int getNumeroPosti() { return numeroPosti; }

    public void setNumeroPosti(int numeroPosti) {
        if (numeroPosti > 0) {
            this.numeroPosti = numeroPosti;
        } else {
            System.out.println("Seats must be positive.");
        }
    }

    public String getCodice() { return codice; }

    public void setCodice(String codice) {
        if (codice != null && !codice.trim().isEmpty()) {
            this.codice = codice;
        } else {
            System.out.println("Invalid code.");
        }
    }

@Override
    public String toString() {
        return "Aereo | Modello: " + modello + " | Posti: " + numeroPosti + " | Codice: " + codice;
    }
}
