package controller;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import model.user.Role;
import model.user.User;
import util.SessionManager;

public class AuthController {

    private final UserDAO userDAO = new UserDAOImpl();

    public void register(String username, String password, Role role) {

        User user = new User(username, password, role);

        userDAO.save(user);
    }

    public boolean login(String username, String password) {

        User user = userDAO.login(username, password);

        if (user != null) {
            SessionManager.getInstance().setLoggedUser(user);
            return true;
        }

        return false;
    }

    public void logout() {
        SessionManager.getInstance().logout();
        System.out.println("Logged out successfully.");
    }
}