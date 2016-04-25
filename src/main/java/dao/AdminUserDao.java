package dao;

import domain.AdminUser;

/**
 * Created by lily on 2016/4/25.
 */
public interface AdminUserDao<T> extends BaseDao<T>{
    public AdminUser login(AdminUser adminUser);
}
