package dao;

import domain.Order;
import domain.OrderItem;

import java.util.List;

/**
 * Created by lily on 2016/4/3.
 */
public interface OrderDao<T> extends BaseDao<T>{
    public int findCountByUid(Long uid);
    public List<Order> findPageByUid(long uid,int begin,int limit);
    public int findCount();
    public List<Order> getByPage(int begin,int limit);
    public List<OrderItem> getOrderByOrderItem(long oid);
}
