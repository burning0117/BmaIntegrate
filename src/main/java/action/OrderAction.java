package action;

import com.opensymphony.xwork2.ActionContext;
import domain.Order;
import domain.Preuser;
import domain.User;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.OrderService;
import service.UserService;
import utils.DeleteMode;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by lily on 2016/4/5.
 */
@Controller("orderAction")
@Scope("prototype")
public class OrderAction extends BaseAction<Order>{
   @Resource(name = "orderService")
   private OrderService orderService;
   @Resource(name = "userService")
   private UserService userService;
   private Long uid;

   public Long getUid() {
      return uid;
   }

   public void setUid(Long uid) {
      this.uid = uid;
   }

   public String getAllOrder(){
      Collection<Order> orderList =this.orderService.getAllGoods();
      ActionContext.getContext().put("orderList", orderList);
      return listAction;
   }
   public String deleteOrder(){
      this.orderService.deleteGood(this.getModel().getOid(), DeleteMode.DEL_PRE_RELEASE);
      return action2action;
   }
   public String addUI(){
      Collection<User> userList= this.userService.getAllUser();
      ActionContext.getContext().put("userList",userList);
      return addUI;
   }
   public String add(){
      Order order =new Order();
      BeanUtils.copyProperties(this.getModel(), order);
//      Preuser user=this.userService.getUserById(this.uid);
//      order.setPreuser(user);
      this.orderService.saveGood(order);
      return action2action;
   }
   public String updateUI(){
      Collection<User> userList=this.userService.getAllUser();
      Order order =this.orderService.getGoodById(this.getModel().getOid());
      ActionContext.getContext().getValueStack().getRoot().add(0, order);
      ActionContext.getContext().put("userList",userList);
      return updateUI;
   }
   public String update(){
      Order order =this.orderService.getGoodById(this.getModel().getOid());
      BeanUtils.copyProperties(this.getModel(), order);
      User user=this.userService.getUserById(this.uid);
//      order.setUser(user);
      this.orderService.updateGood(order);
      return action2action;
   }
}
