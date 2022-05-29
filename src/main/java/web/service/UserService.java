package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUser(long id);
    void saveUser(User user);
    void deleteUser(User user);
    User updateUser(User user);
    User findUserByUsername(String username);
}
