package dao;

import domain.Production;

import java.util.List;

/**
 * Created by lily on 2016/4/5.
 */
public interface ProductionDao<T> extends BaseDao<T>{
    public List<Production> findHot();
    public List<Production> findNew();
    public int findCountCid(Integer cid);
    public List<Production> findByPageCid(Integer cid,int begin,int limit);
    public int findCountCsid(Integer csid);
    public List<Production> findBypageCsid(Integer csid,int begin,int limit);
    public int findCount();
    public List<Production> findByPage(int begin,int limit);
}
