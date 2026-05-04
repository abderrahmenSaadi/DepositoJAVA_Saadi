public abstract class DecoratoreBevanda implements Bevanda {

    protected Bevanda bevanda;

    public DecoratoreBevanda(Bevanda bevanda) {
        this.bevanda = bevanda;
    }
}