package service;

import dao.AdminUserDao;
import domain.AdminUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lily on 2016/4/25.
 */
@Service("adminUserService")
public class AdminUserServiceImpl implements AdminUserService{
    @Resource(name = "adminUserDao")
    private AdminUserDao adminUserDao;
    public AdminUser login(AdminUser adminUser) {
//        return this.adminUserDao.l();
        return this.adminUserDao.login(adminUser);
    }
}
