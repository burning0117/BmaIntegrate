package dao;

import domain.Production;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import utils.PageHibernateCallback;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by lily on 2016/4/5.
 */
@Repository("productionDao")
public class ProductionDaoImpl extends BaseDaoImpl<Production> implements ProductionDao<Production> {

    public List<Production> findHot() {
        DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Production.class);
        detachedCriteria.add(Restrictions.eq("is_hot", 1));
        detachedCriteria.addOrder(Order.desc("pdate"));
        List<Production> list=this.hibernateTemplate.findByCriteria(detachedCriteria,0,10);
        return list;
    }

    public List<Production> findNew() {
        DetachedCriteria criteria=DetachedCriteria.forClass(Production.class);
        criteria.addOrder(Order.desc("pdate"));
        List<Production> list=this.hibernateTemplate.findByCriteria(criteria,0,10);
        return list;
    }

    public int findCountCid(Long cid) {
        String hql = "select count(*) from Production p where p.categorySecond.category.cid=?";
        List<Long> list = this.hibernateTemplate.find(hql, cid);
        if (list != null && list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    public List<Production> findByPageCid(Long cid, int begin, int limit) {
        String hql = "select p from Production p join p.categorySecond cs join cs.category c where c.cid = ?";
        List<Production> list = (List<Production>) this.hibernateTemplate.execute(new PageHibernateCallback<Production>(hql, new Object[]{cid}, begin, limit));
        if (list != null && list.size() > 0) {
            return list;
        }
        return null;
    }

    public int findCountCsid(Long csid) {
        String hql = "select count(*) from Production p where p.categorySecond.csid = ?";
        List<Long> list = this.hibernateTemplate.find(hql, csid);
        if (list != null && list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    public List<Production> findBypageCsid(Long csid, int begin, int limit) {
        String hql = "select p from Production p join p.categorySecond cs where cs.csid = ?";
        List<Production> list = (List<Production>) this.hibernateTemplate.execute(new PageHibernateCallback<Production>(hql, new Object[]{csid}, begin, limit));
        if (list != null && list.size() > 0) {
            return list;
        }
        return null;
    }

    public int findCount() {
        String hql = "select count(*) from Production";
        List<Long> list = this.hibernateTemplate.find(hql);
        if (list != null && list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    public List<Production> findByPage(int begin, int limit) {
        String hql = "from Production order by pdate desc";
        List<Production> list = (List<Production>) this.hibernateTemplate.execute(new PageHibernateCallback<Production>(hql, null, begin, limit));
        if (list != null && list.size() > 0) {
            return list;
        }
        return null;
    }
}
