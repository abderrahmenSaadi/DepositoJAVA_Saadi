
public class DecoratoreMaiuscolo implements Messaggio {
    private Messaggio messaggio;

    public DecoratoreMaiuscolo(Messaggio messaggio) {
        this.messaggio = messaggio;
    }

    @Override
    public String getContenuto() {
        return messaggio.getContenuto().toUpperCase();
    }
 public Messaggio getMessaggio() {
        return messaggio;
    }
    public void setMessaggio(Messaggio messaggio) {
        this.messaggio = messaggio;
    }
    
}
