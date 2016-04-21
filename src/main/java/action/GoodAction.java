package action;

import com.opensymphony.xwork2.ActionContext;
import domain.Good;
import domain.User;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.GoodService;
import service.UserService;
import utils.DeleteMode;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by lily on 2016/4/5.
 */
@Controller("goodAction")
@Scope("prototype")
public class GoodAction extends BaseAction<Good>{
   @Resource(name = "goodService")
   private GoodService goodService;
   @Resource(name = "userService")
   private UserService userService;
   private Long uid;

   public Long getUid() {
      return uid;
   }

   public void setUid(Long uid) {
      this.uid = uid;
   }

   public String getAllGood(){
      Collection<Good> goodList=this.goodService.getAllGoods();
      ActionContext.getContext().put("goodList",goodList);
      return listAction;
   }
   public String deleteGood(){
      this.goodService.deleteGood(this.getModel().getGid(), DeleteMode.DEL_PRE_RELEASE);
      return action2action;
   }
   public String addUI(){
      Collection<User> userList= this.userService.getAllUser();
      ActionContext.getContext().put("userList",userList);
      return addUI;
   }
   public String add(){
      Good good=new Good();
      BeanUtils.copyProperties(this.getModel(), good);
      User user=this.userService.getUserById(this.uid);
      good.setUser(user);
      this.goodService.saveGood(good);
      return action2action;
   }
   public String updateUI(){
      Collection<User> userList=this.userService.getAllUser();
      Good good=this.goodService.getGoodById(this.getModel().getGid());
      ActionContext.getContext().getValueStack().getRoot().add(0, good);
      ActionContext.getContext().put("userList",userList);
      return updateUI;
   }
   public String update(){
      Good good=this.goodService.getGoodById(this.getModel().getGid());
      BeanUtils.copyProperties(this.getModel(),good);
      User user=this.userService.getUserById(this.uid);
      good.setUser(user);
      this.goodService.updateGood(good);
      return action2action;
   }
}
