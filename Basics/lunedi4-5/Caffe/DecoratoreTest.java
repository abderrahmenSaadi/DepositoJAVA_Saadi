public class DecoratoreTest {

    public static void main(String[] args) {

        // Base coffee
        Bevanda caffeBase = new Caffe();
        System.out.println("Bevanda: " + caffeBase.descrizione());
        System.out.println("Costo: " + caffeBase.costo() + " euro\n");

        // Coffee + milk
        Bevanda caffeConLatte = new Latte(new Caffe());
        System.out.println("Bevanda: " + caffeConLatte.descrizione());
        System.out.println("Costo: " + caffeConLatte.costo() + " euro\n");

        // Coffee + milk + chocolate
        Bevanda caffeCompleto = new Cioccolato(new Latte(new Caffe()));
        System.out.println("Bevanda: " + caffeCompleto.descrizione());
        System.out.println("Costo: " + caffeCompleto.costo() + " euro\n");

        // Coffee + milk + chocolate + cream
        Bevanda caffeSpeciale = new Panna(
                new Cioccolato(
                        new Latte(
                                new Caffe()
                        )
                )
        );

        System.out.println("Bevanda: " + caffeSpeciale.descrizione());
        System.out.println("Costo: " + caffeSpeciale.costo() + " euro");
    }
}