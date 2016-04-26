package service;

import dao.CategorySecondDao;
import domain.CategorySecond;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utils.PageBean;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by lily on 2016/4/25.
 */
@Service("categorySecondService")
public class CategorySecondServiceImpl implements CategorySecondService{
    @Resource(name = "categorySecondDao")
    private CategorySecondDao categorySecondDao;
    public PageBean<CategorySecond> findByPage(Integer page) {
        PageBean<CategorySecond> pageBean=new PageBean<CategorySecond>();
        pageBean.setPage(page);
        int limit=10;
        pageBean.setLimit(limit);
        int totalCount=categorySecondDao.findCount();
        pageBean.setTotalCount(totalCount);
        int totalPage=0;
        if (totalCount%limit==0){
            totalPage=totalCount/limit;
        }else {
            totalPage=totalCount/limit+1;
        }
        pageBean.setTotalPage(totalPage);
        int begin=((Integer)page-1)*limit;
        List<CategorySecond> list=categorySecondDao.findByPage(begin,limit);
        pageBean.setList(list);
        return pageBean;
    }
    @Transactional(readOnly = false)
    public void saveCategorySecond(CategorySecond categorySecond) {
        System.out.println("1111111");
        categorySecondDao.saveEntry(categorySecond);
    }
    @Transactional(readOnly = false)
    public void deleteCategorySecond(CategorySecond categorySecond) {
        categorySecondDao.deleteEntry(categorySecond);
    }

    public CategorySecond getCategorySecondByCsid(Serializable id) {
        return (CategorySecond) categorySecondDao.getEntryById(id);
    }
    @Transactional(readOnly = false)
    public void updateCategorySecond(CategorySecond categorySecond) {
        categorySecondDao.updateEntry(categorySecond);
    }

    public List<CategorySecond> getAllCategorySecond() {
        return (List<CategorySecond>) categorySecondDao.getAllEntry();
    }
}
