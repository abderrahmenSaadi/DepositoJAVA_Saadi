import java.util.ArrayList;
// ================= COMPAGNIA =================
class CompagniaAerea {
    private String nome;
    private ArrayList<Aereo> flotta = new ArrayList<>();
    private ArrayList<Pilota> piloti = new ArrayList<>();

    public CompagniaAerea(String nome) {
        this.nome = nome;
    }

    public void aggiungiAereo(Aereo a) {
        if (a != null) flotta.add(a);
    }

    public void aggiungiPilota(Pilota p) {
        if (p != null) piloti.add(p);
    }
    public String getNome() {
    return nome;
}

    public void stampaInfo() {
        System.out.println("\n=== " + nome + " ===");

        System.out.println("\n-- Flotta --");
        if (flotta.isEmpty()) System.out.println("No airplanes.");
        else for (Aereo a : flotta) System.out.println(a);

        System.out.println("\n-- Piloti --");
        if (piloti.isEmpty()) System.out.println("No pilots.");
        else for (Pilota p : piloti) System.out.println(p);
    }
}