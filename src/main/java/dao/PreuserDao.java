package dao;

import domain.Preuser;

import java.util.List;

/**
 * Created by lily on 2016/4/3.
 */
public interface PreuserDao<T> extends BaseDao<T> {
    public Preuser getUserByName(String username);
    public Preuser findByCode(String code);
    public List<Preuser> findByPage(int begin,int limit);
    public int findCount();
    public Preuser login(Preuser preuser);
}
