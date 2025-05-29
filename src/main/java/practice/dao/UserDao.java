package practice.dao;

import practice.models.User;

import java.util.List;

public interface UserDao {
    void createUserTable();
    void dropUserTable();

    void addUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    String updateUserById(Long id, User user);
    String deleteUserById(Long id);
    List<User> searchUserByName(String userName);
}
