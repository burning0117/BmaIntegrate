package service;

import domain.Category;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by lily on 2016/4/24.
 */
public interface CategoryService {
    public void saveCategory(Category category);
    public void deleteCatory(Category category);
    public void updateCatory(Category category);
    public Collection<Category> getAllCategory();
    public Category getCategoryById(Serializable id);
}
