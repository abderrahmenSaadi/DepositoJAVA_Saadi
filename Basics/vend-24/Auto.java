public class Auto extends Veicolo {
    private int numPorte;

    public Auto(String marca, int velocitaMax, int numPorte) {
        super(marca, velocitaMax);
        this.numPorte = numPorte;
    }

    public int getNumPorte() {
        return numPorte;
    }

    @Override
    public void descrivi() {
        System.out.println(getMarca() + " — velocità massima: " 
            + getVelocitaMax() + " km/h — porte: " + numPorte);
    }
}