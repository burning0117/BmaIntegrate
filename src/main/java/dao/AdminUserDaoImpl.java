package dao;

import domain.AdminUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lily on 2016/4/25.
 */
@Repository("adminUserDao")
public class AdminUserDaoImpl extends BaseDaoImpl<AdminUser> implements AdminUserDao<AdminUser> {
    public AdminUser login(AdminUser adminUser) {
        String hql = "from AdminUser where username= ? and password= ?";
        List<AdminUser> list=this.hibernateTemplate.find(hql,new Object[]{adminUser.getUsername(),adminUser.getPassword()});
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
