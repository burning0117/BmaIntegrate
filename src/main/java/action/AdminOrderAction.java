package action;

import com.opensymphony.xwork2.ActionContext;
import domain.Order;
import domain.OrderItem;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.OrderService;
import utils.PageBean;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lily on 2016/4/25.
 */
@Controller("adminOrderAction")
@Scope("prototype")
public class AdminOrderAction extends BaseAction<Order>{
    private Order order;
    @Resource(name= "orderService")
    private OrderService orderService;
    private Integer page;
    public String findAll(){
        PageBean<Order> pageBean=orderService.findAll(page);
        ActionContext.getContext().getValueStack().set("pageBean",pageBean);
        return "findAll";
    }
    public String updateState(){
        Order currentOrder=orderService.getOrderById(order.getOid());
        currentOrder.setState(3);
        orderService.updateOrder(currentOrder);
        return "updateStateSuccess";
    }
    public String findOrderItem(){
        List<OrderItem> list=orderService.findOrderItem(order.getOid());
        ActionContext.getContext().getValueStack().set("list",list);
        return "findOrderItem";
    }
}
