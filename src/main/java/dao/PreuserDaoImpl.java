package dao;

import domain.Preuser;
import domain.User;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by lily on 2016/4/3.
 */
@Repository("preuserDao")
public class PreuserDaoImpl extends BaseDaoImpl<Preuser> implements PreuserDao<Preuser> {

    public Preuser getUserByName(String name) {
        List<Preuser> preuserList = this.hibernateTemplate.find("from Preuser where name=?", name);
        if (preuserList.size() == 0) {
            return null;
        } else {
            return preuserList.get(0);
        }
    }

    public Preuser findByCode(String code) {
        List<Preuser>  codeList= this.hibernateTemplate.find("from Preuser where code=?", code);
        if (codeList.size()==0){
            return null;
        }else {
            return codeList.get(0);
        }
    }

    public List<Preuser> findByPage(int begin, int limit) {
//        List<User> list=this.hibernateTemplate.execute()
        return null;
    }

    public int findCount() {
        return 0;
    }

    public Preuser login(User user) {
        return null;
    }
}
