package practice.service.serviceImpl;

import practice.dao.UserDao;
import practice.dao.daoImpl.UserDaoImpl;
import practice.models.User;
import practice.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    final UserDao userDao = new UserDaoImpl();
    @Override
    public void createUserTable() {
        userDao.createUserTable();
    }

    @Override
    public void dropUserTable() {
        userDao.dropUserTable();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public String updateUserById(Long id, User user) {
        return userDao.updateUserById(id, user);
    }

    @Override
    public String deleteUserById(Long id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public List<User> searchUserByName(String userName) {
        return userDao.searchUserByName(userName);
    }
}
