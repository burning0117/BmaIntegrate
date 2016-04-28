package service;

import domain.Order;
import domain.OrderItem;
import utils.PageBean;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by lily on 2016/4/5.
 */
public interface OrderService {
    public void saveOrder(Order order);
    public void deleteOrder(Order order);
    public void updateOrder(Order order);
    public Collection<Order> getAllOrders();
    public Order getOrderById(Serializable id);
    public PageBean<Order> findByUid(Long uid,Integer page);
    public List<OrderItem> findOrderItem(Long oid);
    public PageBean<Order> findAll(Integer page);
}
