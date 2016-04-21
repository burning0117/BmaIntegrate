package dao;

import domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lily on 2016/4/3.
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao<User>{
    public User getUserByName(String name) {
        List<User> userList = this.hibernateTemplate.find("from User where name=?", name);
        if (userList.size()==0){
            return null;
        }else {
            return userList.get(0);
        }
    }
}
