package action;

import domain.Preuser;
import domain.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.UserService;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by lily on 2016/4/5.
 */
@Controller("preuserAction")
@Scope("prototype")
public class PreuserAction extends BaseAction<User>{
    @Resource(name = "")
    private UserService userService;
    private Preuser preuser=new Preuser();
    private String checkcode;
    public String registPage(){
        return "registPage";
    }
    public String findByName()throws IOException{
//        Preuser existUser=userService.getUserByName(preuser.getName());
        return null;
    }
}
