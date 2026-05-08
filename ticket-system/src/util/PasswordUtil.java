package util;

import strategy.PasswordStrategy;
import strategy.SHA256PasswordStrategy;

public class PasswordUtil {

    private static final PasswordStrategy strategy = new SHA256PasswordStrategy();

    public static String hashPassword(String password) {
        return strategy.hashPassword(password);
    }
}