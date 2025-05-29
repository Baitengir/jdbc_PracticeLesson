package practice.dao.daoImpl;

import practice.config.DBConfig;
import practice.dao.UserDao;
import practice.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    Connection connection = DBConfig.getConnection();

    @Override
    public void createUserTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS users (
                    id SERIAL PRIMARY KEY,
                    name VARCHAR(50) NOT NULL,
                    email VARCHAR(50) NOT NULL,
                    password VARCHAR(50) NOT NULL
                )
                """;
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("User table created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropUserTable() {
        String sql = "DROP TABLE IF NOT EXISTS users";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("User table deleted");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addUser(User user) {
        String sql = """
                INSERT INTO users (name, email, password)
                VALUES (?,?,?)
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();
            System.out.println("User added");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public User getUserById(Long id) {
        String sql = """
                SELECT *
                FROM users
                WHERE id = ?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("error");
        return new User();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return List.of();
    }

    @Override
    public String updateUserById(Long id, User user) {
        String sql = """
                UPDATE users
                SET name = ?,
                email = ?,
                password = ?
                WHERE id = ?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();
            return "user updated";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "error";
    }

    @Override
    public String deleteUserById(Long id) {
        String sql = """
                DELETE FROM users
                WHERE id = ?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            return "user deleted";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "error";
    }

    @Override
    public List<User> searchUserByName(String userName) {
        List<User> users = new ArrayList<>();
        String sql = """
                SELECT *
                FROM users
                WHERE name = ?
                """;
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, userName);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return List.of();
    }
}
