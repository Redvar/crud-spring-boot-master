package web.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public List<User> getUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public User getUser(long id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }


    @Override
    @Transactional
    public User updateUser(User user) {
        User userFromDb = userDao.findUserByUsername(user.getUsername());

        if (userFromDb == null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userDao.updateUser(user);
    }

    @Override
    @Transactional
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

}

