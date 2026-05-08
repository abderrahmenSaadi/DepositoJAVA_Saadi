package strategy;

public interface PasswordStrategy {

    String hashPassword(String password);
}