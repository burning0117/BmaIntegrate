package action;

import com.opensymphony.xwork2.ActionContext;
import domain.Preuser;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.PreuserService;
import utils.PageBean;

import javax.annotation.Resource;

/**
 * Created by lily on 2016/4/21.
 */
@Controller("userAdminAction")
@Scope("prototype")
public class UserAdminAction extends BaseAction<Preuser>{
    @Resource(name = "preuserService")
    private PreuserService preuserService;
    private Integer page;
    private Preuser preuser=new Preuser();
    public String findAll(){
        PageBean<Preuser> pageBean=preuserService.findByPage(page);
        ActionContext.getContext().getValueStack().set("pageBean",pageBean);
        return "findAll";
    }
    public String delete(){
        Preuser existUser=preuserService.findByUid(this.getModel().getPuid());
        preuserService.deletePreuser(existUser);
        return "deleteSuccess";
    }
    public String edit(){
        return "editSuccess";
    }
    public String update(){
        preuserService.updatePreuser(this.getModel());
        return "updateSuccess";
    }

    public Preuser getPreuser() {
        return preuser;
    }

    public void setPreuser(Preuser preuser) {
        this.preuser = preuser;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
