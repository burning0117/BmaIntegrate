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
@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User>{
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

    public String getAllUser(){
        Collection<User> userList=this.userService.getAllUser();
        ActionContext.getContext().put("userList",userList);
        return listAction;
    }
    public String deleteUser(){
        System.out.println(this.getModel().getUid());
        this.userService.deleteUserById(this.getModel().getUid(), DeleteMode.DEL_PRE_RELEASE);
        return action2action;
    }
    public String addUI(){
        return addUI;
    }
    public String add(){
        User user=new User();
        BeanUtils.copyProperties(this.getModel(), user);
        this.userService.saveUser(user);
        return action2action;
    }
    public String updateUI(){
        User user=this.userService.getUserById(this.getModel().getUid());
        ActionContext.getContext().getValueStack().getRoot().add(0, user);
        return updateUI;
    }
    public String update(){
        User user=this.userService.getUserById(this.getModel().getUid());
        BeanUtils.copyProperties(this.getModel(),user);
        this.userService.updateUser(user);
        return action2action;
    }
    public String checkUsername(){
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
