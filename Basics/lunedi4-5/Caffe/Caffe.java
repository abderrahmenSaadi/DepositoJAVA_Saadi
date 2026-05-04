public class Caffe implements Bevanda {

    @Override
    public String descrizione() {
        return "Caffè";
    }

    @Override
    public double costo() {
        return 1.00;
    }
}