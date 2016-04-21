package dao;

import domain.User;

/**
 * Created by lily on 2016/4/3.
 */
public interface UserDao<T> extends BaseDao<T> {
    public User getUserByName(String name);
}
