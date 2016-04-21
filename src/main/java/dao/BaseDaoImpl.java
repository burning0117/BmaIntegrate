package dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

/**
 * Created by burning on 2016/3/20.
 */
public class BaseDaoImpl<T>implements BaseDao<T> {
    private Class classt;
    public BaseDaoImpl() {
        ParameterizedType type= (ParameterizedType) this.getClass().getGenericSuperclass();//为泛型
        this.classt = (Class) type.getActualTypeArguments()[0];//得到的是<>中的第一个参数
//        System.out.println(type.getRawType());//得到的是BaseDaoImpl
    }
    @Resource(name = "hibernateTemplate")
    public HibernateTemplate hibernateTemplate;

    public Collection<T> getAllEntry() {
        return this.hibernateTemplate.find("from "+this.classt.getName());
    }

    public T getEntryById(Serializable id) {
        return (T) this.hibernateTemplate.get(this.classt,id);
    }

    public void saveEntry(T t) {
        this.hibernateTemplate.save(t);
    }

    public void updateEntry(T t) {
        this.hibernateTemplate.update(t);
    }

    public void deleteEntry(Serializable id) {
        T t=this.getEntryById(id);
        this.hibernateTemplate.delete(t);
    }
}
