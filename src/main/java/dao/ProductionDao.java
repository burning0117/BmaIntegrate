package dao;

import domain.Production;

import java.util.List;

/**
 * Created by lily on 2016/4/5.
 */
public interface ProductionDao<T> extends BaseDao<T>{
    public List<Production> findHot();
    public List<Production> findNew();
    public int findCountCid(Long cid);
    public List<Production> findByPageCid(Long cid,int begin,int limit);
    public int findCountCsid(Long csid);
    public List<Production> findBypageCsid(Long csid,int begin,int limit);
    public int findCount();
    public List<Production> findByPage(int begin,int limit);
}
