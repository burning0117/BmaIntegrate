package dao;

import domain.CategorySecond;

import java.util.List;

/**
 * Created by lily on 2016/4/24.
 */
public interface CategorySecondDao<T> extends BaseDao<T>{
    public int findCount();
    public List<CategorySecond> findByPage(int begin,int end);
}
