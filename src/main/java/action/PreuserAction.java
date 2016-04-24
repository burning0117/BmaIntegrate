package action;

import com.opensymphony.xwork2.ActionContext;
import domain.User;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.UserService;
import utils.DeleteMode;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by lily on 2016/4/5.
 */
@Controller("preuserAction")
@Scope("prototype")
public class PreuserAction extends BaseAction<User>{
    @Resource(name = "userService")
    private UserService userService;
    private String message;
    private String password2;

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String update(){
        User user=this.userService.getUserByName(this.getModel().getName());
        System.out.println(this.getModel().getName()+":");
        if (user==null){
            this.message="该用户名可以使用";
//            ActionContext.getContext().getValueStack().push("该用户名可以使用");
        }else {
            this.message="该用户名已经存在";
//            ActionContext.getContext().getValueStack().push("该用户名已经存在");
        }
        return SUCCESS;
    }
}
