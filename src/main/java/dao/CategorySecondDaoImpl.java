package dao;

import domain.CategorySecond;
import org.springframework.stereotype.Repository;
import utils.PageHibernateCallback;

import java.util.List;

/**
 * Created by lily on 2016/4/24.
 */
@Repository("categorySecondDao")
public class CategorySecondDaoImpl extends BaseDaoImpl<CategorySecond> implements CategorySecondDao<CategorySecond>{
    public int findCount() {
        String hql="select count(*) from CategorySecond";
        List<Long> list=this.hibernateTemplate.find(hql);
        if (list!=null&&list.size()>0){
            return list.get(0).intValue();
        }
        return 0;
    }

    public List<CategorySecond> findByPage(int begin, int limit) {
        String hql="from CategorySecond order by csid desc";
        List<CategorySecond> list= (List<CategorySecond>) this.hibernateTemplate.execute(new PageHibernateCallback<CategorySecond>(hql,null,begin,limit));
        return list;
    }
}
