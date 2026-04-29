public class User {
    private static User instance;
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private User() {
        // Private constructor to prevent instantiation
    }   
    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }
        public static void main(String[] args) {
        
    
    Logger logger = Logger.getInstance();
    User user = User.getInstance();
    user.setName("Mohamed");
    User user2 = User.getInstance();
    user2.setName("Ali");
    logger.ScriviMessaggio("User name: " + user.getName());
    logger.ScriviMessaggio("User2 name: " + user2.getName());
    if (user == user2) {
        logger.ScriviMessaggio("user e user2 sono la stessa istanza.");
    } else {
        logger.ScriviMessaggio("user e user2 sono istanze diverse.");

    }


    
}
    
}
