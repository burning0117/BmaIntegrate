package service;

import domain.CategorySecond;
import utils.PageBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lily on 2016/4/24.
 */
public interface CategorySecondService {
    public PageBean<CategorySecond> findByPage(Serializable page);
    public void saveCategorySecond(CategorySecond categorySecond);
    public void deleteCategorySecond(CategorySecond categorySecond);
    public  CategorySecond getCategorySecondByCsid(Serializable id);
    public void updateCategorySecond(CategorySecond categorySecond);
    public List<CategorySecond> getAllCategorySecond();
}
