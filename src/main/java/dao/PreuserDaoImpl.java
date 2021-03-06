package dao;

import domain.Preuser;
import org.springframework.stereotype.Repository;
import utils.PageHibernateCallback;

import java.util.List;

/**
 * Created by lily on 2016/4/3.
 */
@Repository("preuserDao")
public class PreuserDaoImpl extends BaseDaoImpl<Preuser> implements PreuserDao<Preuser> {

    public Preuser getUserByName(String username) {
        List<Preuser> preuserList = this.hibernateTemplate.find("from Preuser where username=?", username);
        if (preuserList.size() == 0) {
            return null;
        } else {
            return preuserList.get(0);
        }
    }

    public Preuser findByCode(String code) {
        List<Preuser> codeList = this.hibernateTemplate.find("from Preuser where code=?", code);
        if (codeList != null && codeList.size() > 0) {
            return codeList.get(0);
        }
        return null;
    }

    public List<Preuser> findByPage(int begin, int limit) {
        String hql="from Preuser";
        List<Preuser> list= (List<Preuser>) this.hibernateTemplate.execute(new PageHibernateCallback<Preuser>(hql,null,begin,limit));
        return list;
    }

    public int findCount() {
        String hql="select count(*) from Preuser";
        List<Long> list=this.hibernateTemplate.find(hql);
        if (list!=null&&list.size()>0){
            return list.get(0).intValue();
        }
        return 0;
    }

    public Preuser login(Preuser preuser) {
        String hql="from Preuser where username=? and password=? and state=?";
        List<Preuser> list=this.hibernateTemplate.find(hql,new Object[]{preuser.getUsername(),preuser.getPassword(),1});
        if (list!=null&&list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
