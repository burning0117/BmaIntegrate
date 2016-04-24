package service;

import dao.OrderDao;
import domain.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by lily on 2016/4/5.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource(name = "orderDao")
    private OrderDao orderDao;

    @Transactional(readOnly = false)
    public void saveGood(Order order) {
        this.orderDao.saveEntry(order);
    }

    @Transactional(readOnly = false)
    public void deleteGood(Serializable id, String deleteMode) {
        this.orderDao.deleteEntry(id);
    }

    @Transactional(readOnly = false)
    public void updateGood(Order order) {
        this.orderDao.updateEntry(order);
    }

    public Collection<Order> getAllGoods() {
        return this.orderDao.getAllEntry();
    }

    public Order getGoodById(Serializable id) {
        return (Order) this.orderDao.getEntryById(id);
    }
}
