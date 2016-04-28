package action;

import domain.Preuser;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.PreuserService;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by lily on 2016/4/5.
 */
@Controller("preuserAction")
@Scope("prototype")
public class PreuserAction extends BaseAction<Preuser>{
    @Resource(name = "preuserService")
    private PreuserService preuserService;
    private Preuser preuser;
    private String checkcode;
    public String registPage(){
        return "registPage";
    }
    public String message;
    public String findByName()throws IOException{
        Preuser user=this.preuserService.findByUserName(this.getModel().getUsername());
        if (user==null){
            this.message="该用户名可以使用";
        }else {
            this.message="该用户名已经存在";
        }
        return SUCCESS;
    }
    public String regist(){
        String checkcode1= (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
        String checkcode=this.getModel().getCheckcode();
        if (!checkcode1.equalsIgnoreCase(checkcode)){
            this.addActionError("验证码输入错误");
            return "checkCodeFail";
        }
        preuser=this.getModel();
        preuserService.savePreuser(preuser);
        this.addActionMessage("注册成功！请去邮箱激活");
        return "msg";
    }
    public String active(){
        Preuser existUser=preuserService.findByCode(this.getModel().getCode());
        if (existUser==null){
            this.addActionMessage("激活失败;激活码错误");
        }else {
            existUser.setState(1);
            existUser.setCheckcode(null);
            preuserService.updatePreuser(existUser);
            this.addActionMessage("激活成功:请去登录!");
        }
        return "msg";
    }
    public String loginPage(){
        return "loginPage";
    }
    public String login(){
        Preuser existUser=preuserService.login(this.getModel());
        if (existUser==null){
            this.addActionError("登录失败：用户名或密码错误或用户未激活");
            return "loginPage";
        }else {
            ServletActionContext.getRequest().getSession().setAttribute("existUser",existUser);
            return "loginSuccess";
        }
    }
    public String quit(){
        ServletActionContext.getRequest().getSession().invalidate();
        return "quit";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
