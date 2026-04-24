public class Veicolo {
    private String marca;
    private int velocitaMax;

    public Veicolo(String marca, int velocitaMax) {
        this.marca = marca;
        this.velocitaMax = velocitaMax;
    }

    public String getMarca() {
        return marca;
    }

    public int getVelocitaMax() {
        return velocitaMax;
    }

    public void descrivi() {
        System.out.println(marca + " — velocità massima: " + velocitaMax + " km/h");
    }
}