package service;

import dao.CategoryDao;
import domain.Category;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by lily on 2016/4/24.
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{
    @Resource(name = "categoryDao")
    private CategoryDao categoryDao;
    public void saveCategory(Category category) {
        this.categoryDao.saveEntry(category);
    }

    public void deleteCatory(Serializable id, String deleteMode) {
        this.categoryDao.deleteEntry(id);
    }

    public void updateCatory(Category category) {
        this.categoryDao.updateEntry(category);
    }

    public Collection<Category> getAllCategory() {
        return this.categoryDao.getAllEntry();
    }

    public Category getCategoryById(Serializable id) {
        return (Category) this.categoryDao.getEntryById(id);
    }
}
