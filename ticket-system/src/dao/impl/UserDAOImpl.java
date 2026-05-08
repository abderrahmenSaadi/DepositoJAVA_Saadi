package dao.impl;

import config.DatabaseConnection;
import dao.UserDAO;
import model.user.Role;
import model.user.User;
import util.PasswordUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImpl implements UserDAO {

    private final Connection connection = DatabaseConnection.getInstance().getConnection();

    @Override
    public void save(User user) {

        String sql = "INSERT INTO users(username,password,role) VALUES(?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, user.getUsername());
            statement.setString(2, PasswordUtil.hashPassword(user.getPassword()));
            statement.setString(3, user.getRole().name());

            statement.executeUpdate();

            System.out.println("User registered successfully.");

        } catch (Exception e) {
            System.out.println("Username already exists.");
        }
    }

    @Override
    public User login(String username, String password) {

        String sql = "SELECT * FROM users WHERE username=? AND password=?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, username);
            statement.setString(2, PasswordUtil.hashPassword(password));

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(Role.valueOf(rs.getString("role")));

                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}