public class Utente {
    private String nome;
    private String dato;

    public Utente(String nome, String dato) {
        this.nome = nome;
        this.dato = dato;
    }

    public String getNome() {
        return nome;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }
}