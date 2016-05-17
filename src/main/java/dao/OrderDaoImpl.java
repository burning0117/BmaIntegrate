package dao;

import domain.Order;
import domain.OrderItem;
import org.springframework.stereotype.Repository;
import utils.PageHibernateCallback;

import java.util.List;

/**
 * Created by lily on 2016/4/3.
 */
@Repository("orderDao")
public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao<Order> {
    public int findCountByUid(Long uid) {
        String hql = "select count(*) from Order o where o.preuser.puid = ?";
        List<Long> list = this.hibernateTemplate.find(hql, uid);
        if (list != null && list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    public List<Order> findPageByUid(long uid, int begin, int limit) {
        String hql = "from Order where o.puser.puid = ? order by o.ordertime desc";
        List<Order> list = (List<Order>) this.hibernateTemplate.execute(new PageHibernateCallback<Order>(hql, new Object[]{uid}, begin, limit));
        if (list != null && list.size() > 0) {
            return list;
        }
        return null;
    }

    public int findCount() {
        String hql = "select count(*) from Order";
        List<Long> list = this.hibernateTemplate.find(hql);
        if (list != null && list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    public List<Order> getByPage(int begin, int limit) {
        String hql = "from Order order by ordertime desc";
        List<Order> list = (List<Order>) this.hibernateTemplate.execute(new PageHibernateCallback<Order>(hql, null, begin, limit));
        return list;
    }

    public List<OrderItem> getOrderByOrderItem(long oid) {
        String hql = "from OrderItem oi where oi.order.oid= ?";
        List<OrderItem> list = this.hibernateTemplate.find(hql, oid);
        if (list != null && list.size() > 0) {
            return list;
        }
        return null;
    }
}

