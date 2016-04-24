package dao;

import domain.Order;
import org.springframework.stereotype.Repository;

/**
 * Created by lily on 2016/4/3.
 */
@Repository("orderDao")
public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao<Order> {
}

