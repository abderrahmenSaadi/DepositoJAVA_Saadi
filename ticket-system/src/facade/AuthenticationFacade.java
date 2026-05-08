package facade;

import controller.AuthController;
import model.user.Role;

public class AuthenticationFacade {

    private final AuthController authController = new AuthController();

    public void register(String username, String password, Role role) {
        authController.register(username, password, role);
    }

    public boolean login(String username, String password) {
        return authController.login(username, password);
    }

    public void logout() {
        authController.logout();
    }
}