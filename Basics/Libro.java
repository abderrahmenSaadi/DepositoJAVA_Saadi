public class Libro {
    private static int contatore = 1;

    private int codice;
    private String titolo;
    private String autore;
    private double prezzo;

    public Libro(String titolo, String autore, double prezzo) {
        this.titolo = titolo;
        this.autore = autore;
        this.prezzo = prezzo;
        this.codice = contatore++;
    }

    public void stampa() {
        System.out.println(codice + " - " + titolo + " (" + autore + ") - " + prezzo + "€");
    }
}