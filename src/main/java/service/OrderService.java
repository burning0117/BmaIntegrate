package service;

import domain.Order;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by lily on 2016/4/5.
 */
public interface OrderService {
    public void saveGood(Order order);
    public void deleteGood(Serializable id, String deleteMode);
    public void updateGood(Order order);
    public Collection<Order> getAllGoods();
    public Order getGoodById(Serializable id);
}
