package action;

import domain.AdminUser;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.AdminUserService;

import javax.annotation.Resource;

/**
 * Created by lily on 2016/4/25.
 */
@Controller("adminUserAction")
@Scope("prototype")
public class AdminUserAction extends BaseAction<AdminUser>{
    @Resource(name = "adminUserService")
    private AdminUserService adminUserService;
    public String login(){
        AdminUser existAdminUser=adminUserService.login(this.getModel());
        if (existAdminUser==null){
            this.addActionError("用户名或者密码错误");
            return "loginFail";
        }else {
            ServletActionContext.getRequest().getSession().setAttribute("existAdminUser",existAdminUser);
            return "loginSuccess";
        }
    }
}
