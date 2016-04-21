package service;

import domain.Good;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by lily on 2016/4/5.
 */
public interface GoodService {
    public void saveGood(Good good);
    public void deleteGood(Serializable id, String deleteMode);
    public void updateGood(Good good);
    public Collection<Good> getAllGoods();
    public Good getGoodById(Serializable id);
}
