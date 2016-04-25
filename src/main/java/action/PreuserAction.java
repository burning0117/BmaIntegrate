package action;

import domain.Preuser;
import domain.User;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.PreUserServiceImpl;
import service.PreuserService;
import service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lily on 2016/4/5.
 */
@Controller("preuserAction")
@Scope("prototype")
public class PreuserAction extends BaseAction<User>{
    @Resource(name = "preuserService")
    private PreuserService preuserService;
    private Preuser preuser=new Preuser();
    private String checkcode;
    public String registPage(){
        return "registPage";
    }
    public String findByName()throws IOException{
        Preuser existUser=preuserService.findByUserName(preuser.getName());
        HttpServletResponse response= ServletActionContext.getResponse();
        response.setContentType("text/html:charset=UTF-8");
        if (existUser!=null){
            response.getWriter().println("<font color='red'>用户名已经存在</font>");
        }else {
            response.getWriter().println("<font color='green'>用户名可以使用</font>");
        }
        return NONE;
    }
    public String regist(){
        String checkCode= (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
        if (!checkCode.equalsIgnoreCase(checkCode)){
            this.addActionError("验证码输入错误");
            return "checkcodeFail";
        }
        preuserService.savePreuser(preuser);
        this.addActionMessage("注册成功！请去邮箱激活");
        return "msg";
    }
    public String active(){
        Preuser existUser=preuserService.findByCode(preuser.getCode());
        if (existUser==null){
            this.addActionMessage("激活失败;激活码错误");
        }else {
            existUser.setState(1);
            existUser.setCode(null);
            preuserService.updatePreuser(preuser);
            this.addActionMessage("激活成功:请去登录!");
        }
        return "msg";
    }
    public String loginPage(){
        return "loginPage";
    }
    public String login(){
        Preuser existUser=preuserService.login(preuser);
        if (existUser==null){
            this.addActionError("登录失败：用户名或密码错误或用户未激活");
            return LOGIN;
        }else {
            ServletActionContext.getRequest().getSession().setAttribute("existUser",existUser);
            return "loginSuccess";
        }
    }
    public String quit(){
        ServletActionContext.getRequest().getSession().invalidate();;
        return "quit";
    }
}
