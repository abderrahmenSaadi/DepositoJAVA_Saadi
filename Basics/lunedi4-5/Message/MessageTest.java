

public class MessageTest {
    public static void main(String[] args) {
        
        Messaggio messaggioBase = new MessaggioBase("Ciao, come stai?");
        System.out.println("Messaggio originale: " + messaggioBase.getContenuto());

        DecoratoreMaiuscolo decoratoreMaiuscolo = new DecoratoreMaiuscolo(messaggioBase);
        System.out.println("Messaggio in maiuscolo: " + decoratoreMaiuscolo.getContenuto());
    }
    
}
