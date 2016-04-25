package action;

import domain.Cart;
import domain.CartItem;
import domain.Production;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.ProductionService;

import javax.annotation.Resource;

/**
 * Created by lily on 2016/4/25.
 */
@Controller("cartAction")
@Scope("prototype")
public class CartAction extends BaseAction<Cart>{
    @Resource(name = "productionService")
    private ProductionService productionService;
    private Long pid;
    private Integer count;
    public String addCart(){
        CartItem cartItem=new CartItem();
        cartItem.setCount(count);
        Production production=productionService.getProductionById(pid);
        cartItem.setProduction(production);
        Cart cart=getCart();
        cart.addCart(cartItem);
        return "addCart";
    }
    public String clearCart(){
        Cart cart=getCart();
        cart.clearCart();
        return "clearCart";
    }
    public String removeCart(){
        Cart cart=getCart();
        cart.removeCart(pid);
        return "removeCart";
    }
    private Cart getCart(){
        Cart cart= (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
        if (cart==null){
            cart=new Cart();
            ServletActionContext.getRequest().getSession().setAttribute("cart",cart);
        }
        return cart;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
