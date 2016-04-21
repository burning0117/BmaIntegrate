package service;

import dao.UserDao;
import domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by lily on 2016/4/5.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource(name = "userDao")
    private UserDao userDao;

    @Transactional(readOnly = false)
    public void saveUser(User user) {
        this.userDao.saveEntry(user);
    }

    @Transactional(readOnly = false)
    public void updateUser(User user) {
        this.userDao.updateEntry(user);
    }

    @Transactional(readOnly = false)
    public void deleteUserById(Serializable id, String deleteMode) {
        this.userDao.deleteEntry(id);
    }

    public Collection<User> getAllUser() {
        return this.userDao.getAllEntry();
    }

    public User getUserById(Serializable id) {
        return (User) this.userDao.getEntryById(id);
    }

    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }
}
