package service;

import dao.OrderDao;
import domain.Order;
import domain.OrderItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utils.PageBean;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by lily on 2016/4/5.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource(name = "orderDao")
    private OrderDao orderDao;
    @Transactional(readOnly = false)
    public void saveOrder(Order order) {
        this.orderDao.saveEntry(order);
    }

    @Transactional(readOnly = false)
    public void deleteOrder(Order order) {
        this.orderDao.deleteEntry(order);
    }

    @Transactional(readOnly = false)
    public void updateOrder(Order order) {
        this.orderDao.updateEntry(order);
    }

    public Collection<Order> getAllOrders() {
        return this.orderDao.getAllEntry();
    }

    public Order getOrderById(Serializable id) {
        return (Order) this.orderDao.getEntryById(id);
    }

    public PageBean<Order> findByUid(Long uid, Integer page) {
        PageBean<Order> pageBean=new PageBean<Order>();
        pageBean.setPage(page);
        int limit=5;
        pageBean.setLimit(limit);
        int totalCount=orderDao.findCountByUid(uid);
        pageBean.setTotalCount(totalCount);
        int totalPage=0;
        if (totalCount%limit==0){
            totalPage=totalCount/limit;
        }else {
            totalPage=totalCount/limit+1;
        }
        pageBean.setTotalCount(totalPage);
        int begin=(page-1)*limit;
        List<Order> list=orderDao.findPageByUid(uid,begin,limit);
        pageBean.setList(list);
        return null;
    }
    public List<OrderItem> findOrderItem(Long oid) {
        return orderDao.getOrderByOrderItem(oid);
    }

    public PageBean<Order> findAll(Integer page) {
        PageBean<Order> pageBean=new PageBean<Order>();
        pageBean.setPage(page);
        int limit=10;
        pageBean.setLimit(limit);
        int totalCount=orderDao.findCount();
        pageBean.setTotalCount(totalCount);
        int totalPage=0;
        if (totalCount%limit==0){
            totalPage=totalCount/limit;
        }else {
            totalPage=totalCount/limit+1;
        }
        pageBean.setTotalPage(totalPage);
        int begin=(page-1)*limit;
        List<Order> list=orderDao.getByPage(begin,limit);
        pageBean.setList(list);
        return pageBean;
    }
    public List<OrderItem> findOrderItem(Integer oid){
        return orderDao.getOrderByOrderItem(oid);
    }
}
