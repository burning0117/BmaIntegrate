package action;

import com.opensymphony.xwork2.ActionContext;
import domain.Category;
import domain.CategorySecond;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.CategorySecondService;
import service.CategoryService;
import utils.PageBean;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * Created by lily on 2016/4/25.
 */
@Controller("adminCategorySecond")
@Scope("prototype")
public class AdminCategorySecondAction extends BaseAction<CategorySecond>{
    @Resource(name = "categoryService")
    private CategoryService categoryService;
    @Resource(name = "categorySecondService")
    private CategorySecondService categorySecondService;

    private CategorySecond categorySecond=new CategorySecond();
    /*第一页需要查询出来*/
    private Integer page;
    public String findAll(){
        PageBean<CategorySecond> pageBean=categorySecondService.findByPage(page);
        ActionContext.getContext().getValueStack().set("pageBean",pageBean);
        return "findAll";
    }
    public String addPage(){
        List<Category> categoryList= (List<Category>) categoryService.getAllCategory();
        ActionContext.getContext().getValueStack().set("categoryList",categoryList);
        return "addPage";
    }
    public String save(){
        categorySecondService.saveCategorySecond(this.getModel());
        return "saveSuccess";
    }
    public String delete(){
        categorySecondService.deleteCategorySecond(this.getModel());
        return "deleteSuccess";
    }
    public String edit(){
        categorySecond=categorySecondService.getCategorySecondByCsid(this.getModel().getCsid());
        Collection<Category> categoryList=  categoryService.getAllCategory();
        ActionContext.getContext().getValueStack().set("categoryList",categoryList);
        return "editSuccess";
    }
    public String update(){
        categorySecondService.updateCategorySecond(this.getModel());
        return "updateSuccess";
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public CategorySecond getCategorySecond() {
        return categorySecond;
    }

    public void setCategorySecond(CategorySecond categorySecond) {
        this.categorySecond = categorySecond;
    }
}
