public class Cioccolato extends DecoratoreBevanda {

    public Cioccolato(Bevanda bevanda) {
        super(bevanda);
    }

    @Override
    public String descrizione() {
        return bevanda.descrizione() + " + cioccolato";
    }

    @Override
    public double costo() {
        return bevanda.costo() + 0.70;
    }
}