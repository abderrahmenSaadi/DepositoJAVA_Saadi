// ================= PILOTA =================
class Pilota {
    private String nome;
    private String numeroBrevetto;
    private int oreVolo;

    public Pilota(String nome, String numeroBrevetto, int oreVolo) {
        setNome(nome);
        setNumeroBrevetto(numeroBrevetto);
        setOreVolo(oreVolo);
    }

    public String getNome() { return nome; }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        } else {
            System.out.println("Invalid name.");
        }
    }

    public String getNumeroBrevetto() { return numeroBrevetto; }

    public void setNumeroBrevetto(String numeroBrevetto) {
        if (numeroBrevetto != null && !numeroBrevetto.trim().isEmpty()) {
            this.numeroBrevetto = numeroBrevetto;
        } else {
            System.out.println("Invalid license.");
        }
    }

    public int getOreVolo() { return oreVolo; }

    public void setOreVolo(int oreVolo) {
        if (oreVolo > 0) {
            this.oreVolo = oreVolo;
        } else {
            System.out.println("Flight hours must be > 0.");
        }
    }
    @Override
    public String toString() {
        return "Pilota | Nome: " + nome + " | Brevetto: " + numeroBrevetto + " | Ore: " + oreVolo;
    }
}