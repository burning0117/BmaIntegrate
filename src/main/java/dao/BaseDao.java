package dao;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by burning on 2016/3/20.
 */
public interface BaseDao <T>{
    public Collection<T> getAllEntry();
    public T getEntryById(Serializable id);
    public void saveEntry(T t);
    public void updateEntry(T t);
    public void deleteEntry(Serializable id);
}
