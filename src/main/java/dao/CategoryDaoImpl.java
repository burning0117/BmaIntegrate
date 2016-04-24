package dao;

import domain.Category;
import org.springframework.stereotype.Repository;

/**
 * Created by lily on 2016/4/24.
 */
@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao<Category>{
}
