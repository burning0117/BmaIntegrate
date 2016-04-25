package action;

import domain.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.OrderService;
import utils.PageBean;

import javax.annotation.Resource;

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
//        PageBean<Order> pageBean=orderService.getAllOrders(page);
        return "findAll";
    }
}
