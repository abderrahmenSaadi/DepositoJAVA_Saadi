// Hotel class
import java.util.ArrayList;
class Hotel {
    private String nome;
    private ArrayList<Camera> camere;
    private Camera[][][] struttura;

    public Hotel(String nome, int floors, int rows, int cols) {
        this.nome = nome;
        this.camere = new ArrayList<>();
        struttura = new Camera[floors][rows][cols];
    }

    public String getNome() { return nome; }
    public ArrayList<Camera> getCamere() { return camere; }

    public boolean posizioneValida(int f, int r, int c) {
        return f >= 0 && f < struttura.length &&
               r >= 0 && r < struttura[0].length &&
               c >= 0 && c < struttura[0][0].length;
    }

    public boolean aggiungiCamera(Camera cam, int f, int r, int c) {
        if (!posizioneValida(f, r, c)) return false;
        if (struttura[f][r][c] != null) return false;

        camere.add(cam);
        struttura[f][r][c] = cam;
        return true;
    }

    public boolean rimuoviCamera(int numero) {
        boolean removed = camere.removeIf(c -> c.getNumero() == numero);

        for (int f = 0; f < struttura.length; f++)
            for (int i = 0; i < struttura[f].length; i++)
                for (int j = 0; j < struttura[f][i].length; j++)
                    if (struttura[f][i][j] != null && struttura[f][i][j].getNumero() == numero)
                        struttura[f][i][j] = null;

        return removed;
    }

    public void stampaCamere() {
        if (camere.isEmpty()) {
            System.out.println("No rooms available.");
            return;
        }
        for (Camera c : camere) c.dettagli();
    }

    public void stampaMappa() {
        for (int f = 0; f < struttura.length; f++) {
            System.out.println("\n========== FLOOR " + (f + 1) + " ==========");

            for (int i = 0; i < struttura[f].length; i++) {
                for (int j = 0; j < struttura[f][i].length; j++) {
                    if (struttura[f][i][j] != null)
                        System.out.printf("[%3d]", struttura[f][i][j].getNumero());
                    else
                        System.out.print("[   ]");
                }
                System.out.println();
            }
        }
    }

    public static int contaSuite(ArrayList<Camera> lista) {
        int count = 0;
        for (Camera c : lista)
            if (c instanceof Suite) count++;
        return count;
    }
}

