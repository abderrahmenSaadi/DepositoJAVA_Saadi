import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> libri;

    public Biblioteca() {
        libri = new ArrayList<>();
    }

    public void creaLibri() {
        // Creazione libri dentro la biblioteca
        Libro l1 = new Libro("Il Nome della Rosa", "Umberto Eco", 12.5);
        Libro l2 = new Libro("1984", "George Orwell", 10.0);

        libri.add(l1);
        libri.add(l2);
    }

    public void mostraLibri() {
        for (Libro libro : libri) {
            libro.stampa();
        }
    }

    public static void main(String[] args) {
        Biblioteca biblio = new Biblioteca();
        biblio.creaLibri();
        biblio.mostraLibri();
    }
}