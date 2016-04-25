package domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by lily on 2016/4/25.
 */
public class Cart implements Serializable{
    private Map<Long,CartItem> map=new LinkedHashMap<Long, CartItem>();
    private double total;
    public Collection<CartItem> getCartItems(){
        return map.values();
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public void addCart(CartItem cartItem){
        Long pid=cartItem.getProduction().getPid();
        if (map.containsKey(pid)){
            CartItem cartItem1=map.get(pid);
            cartItem1.setCount(cartItem1.getCount()+cartItem.getCount());
        }else {
            map.put(pid,cartItem);
        }
        total+=cartItem.getSubtotal();
    }
    public void removeCart(Long pid){
        CartItem cartItem=map.remove(pid);
        total-=cartItem.getSubtotal();
    }
    public void clearCart(){
        map.clear();
        total=0;
    }
}
