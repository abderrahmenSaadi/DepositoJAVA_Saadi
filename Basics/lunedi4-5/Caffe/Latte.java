public class Latte extends DecoratoreBevanda {

    public Latte(Bevanda bevanda) {
        super(bevanda);
    }

    @Override
    public String descrizione() {
        return bevanda.descrizione() + " + latte";
    }

    @Override
    public double costo() {
        return bevanda.costo() + 0.50;
    }
}