package service;

import dao.CategoryDao;
import domain.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(readOnly = false)
    public void saveCategory(Category category) {
        this.categoryDao.saveEntry(category);
    }
    @Transactional(readOnly = false)
    public void deleteCatory(Serializable id, String deleteMode) {
        this.categoryDao.deleteEntry(id);
    }
    @Transactional(readOnly = false)
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
