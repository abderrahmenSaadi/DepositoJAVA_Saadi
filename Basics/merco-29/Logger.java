public class Logger {
    private static Logger instance;
    private Logger() {
        // Private constructor to prevent instantiation
    }
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    public void ScriviMessaggio(String messaggio) {
        System.out.println(messaggio);
    }
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        
        logger1.ScriviMessaggio("memory address of logger1: " + logger1.hashCode());
        logger2.ScriviMessaggio("memory address of logger2: " + logger2.hashCode());
       
        
        // Verifica che logger1 e logger2 siano la stessa istanza
        if (logger1 == logger2) {
            System.out.println("logger1 e logger2 sono la stessa istanza.");
        } else {
            System.out.println("logger1 e logger2 sono istanze diverse.");
        }
    }
}
