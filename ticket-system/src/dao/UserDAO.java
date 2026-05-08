package dao;

import model.user.User;

public interface UserDAO {

    void save(User user);

    User login(String username, String password);
}