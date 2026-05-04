public class Panna extends DecoratoreBevanda {

    public Panna(Bevanda bevanda) {
        super(bevanda);
    }

    @Override
    public String descrizione() {
        return bevanda.descrizione() + " + panna";
    }

    @Override
    public double costo() {
        return bevanda.costo() + 0.60;
    }
}