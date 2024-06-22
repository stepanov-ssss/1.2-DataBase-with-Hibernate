package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    Connection connection = Util.getConnection();

    public UserDaoJDBCImpl() {}

    public void createUsersTable() {
        final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS users " +
                "(id INT AUTO_INCREMENT  PRIMARY KEY , name VARCHAR(255),last_name VARCHAR (255),age TINYINT )";
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(CREATE_TABLE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        final String DROP_TABLE = "DROP TABLE IF EXISTS users";
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(DROP_TABLE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        final String INSERT_USER = "INSERT INTO users (name, last_name, age) VALUES ( ?, ?, ?)";
        try (PreparedStatement pstm = connection.prepareStatement(INSERT_USER)) {
            pstm.setString(1, name);
            pstm.setString(2, lastName);
            pstm.setByte(3, age);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        final String DELETE_USER = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(DELETE_USER)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        final String SELECT_USERS = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        try (ResultSet resultSet = connection.prepareStatement(SELECT_USERS).executeQuery()) {
            while (resultSet.next()) {
                User user = new User(resultSet.getString("name"),
                        resultSet.getString("last_name"),
                        resultSet.getByte("age"));
                user.setId(resultSet.getLong("id"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public void cleanUsersTable() {
        final String CLEAN_TABLE = "TRUNCATE TABLE users";
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(CLEAN_TABLE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
