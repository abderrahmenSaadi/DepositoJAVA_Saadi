import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class DatabaseManager {
    private static DatabaseManager instance;
    private int connectionCount = 0;
    private Connection connection; // Simulated database connection

    // connection parameters from environment variables
String url = System.getenv("DB_URL");
String user = System.getenv("DB_USER");
String pass = System.getenv("DB_PASSWORD");
 // connection method
public void connect() {
    try {
        String url = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String pass = System.getenv("DB_PASSWORD");

        if (url == null || user == null || pass == null) {
            throw new RuntimeException("Environment variables not set!");
        }

        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, user, pass);
            connectionCount++;
            System.out.println("Connessione stabilita. Connessioni attive: " + connectionCount);
        }
    } catch (Exception e) {
        System.out.println("Errore connessione: " + e.getMessage());
    }
}
 // Singleton pattern implementation
    private DatabaseManager() { }
    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public int getconnectionCount() {
        return connectionCount;
    }
public void saveData(Utente utente) {
    try {
        connect(); 

        String sql = "INSERT INTO utenti (nome, dato) VALUES (?, ?) " ;

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, utente.getNome());
        stmt.setString(2, utente.getDato());

        stmt.executeUpdate();

        System.out.println("Dato salvato/aggiornato per: " + utente.getNome());

    } catch (Exception e) {
        System.out.println("Errore salvataggio: " + e.getMessage());
    }
}



public void printDatabase() {
    try {
        connect(); 

        String sql = "SELECT nome, dato FROM utenti";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.println("Utente: " + rs.getString("nome") +
                               ", Dato: " + rs.getString("dato"));
        }

    } catch (Exception e) {
        System.out.println("Errore stampa DB: " + e.getMessage());
    }
}


public void getData(String nome) {
    try {
        connect(); // ← ADD THIS

        String sql = "SELECT dato FROM utenti WHERE nome = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, nome);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            System.out.println("Dato: " + rs.getString("dato"));
        } else {
            System.out.println("Nessun dato trovato.");
        }

    } catch (Exception e) {
        System.out.println("Errore lettura: " + e.getMessage());
    }
}

    public static void main(String[] args) {
        DatabaseManager db1 = DatabaseManager.getInstance();
        DatabaseManager db2 = DatabaseManager.getInstance();
        
        db1.connect();
        db2.connect();
        
        // Verify that db1 and db2 are the same instance
        if (db1 == db2) {
            System.out.println("db1 and db2 are the same instance.");
        } else {
            System.out.println("db1 and db2 are different instances.");
        }
        System.out.println("Total connections made: " + db1.getconnectionCount());
        System.out.println("Total connections made (via db2): " + db2.getconnectionCount());
        Scanner sc = new Scanner(System.in);
        DatabaseManager db = DatabaseManager.getInstance();

while (true) {
    System.out.println("\n1. Connect");
    System.out.println("2. Save data");
    System.out.println("3. Get data");
    System.out.println("4. Exit");

    int choice = sc.nextInt();
    sc.nextLine();

    switch (choice) {
        case 1:
            db.connect();
            break;

        case 2:
            System.out.print("User: ");
            String user = sc.nextLine();

            System.out.print("Data: ");
            String data = sc.nextLine();

            db.saveData(new Utente(user, data));
            break;

        case 3:
            System.out.print("User: ");
            String u = sc.nextLine();

            db.getData(u);
            break;

        case 4:
            return;
    }
}
    }
    
    
}
