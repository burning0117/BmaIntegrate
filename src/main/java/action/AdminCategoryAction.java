package action;

import com.opensymphony.xwork2.ActionContext;
import domain.Category;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.CategoryService;
import utils.DeleteMode;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by lily on 2016/4/21.
 */
@Controller("adminCategoryAction")
@Scope("prototype")
public class AdminCategoryAction extends BaseAction<Category>{
    @Resource(name = "categoryService")
    private CategoryService categoryService;
    private Category category=new Category();
    public String findAll(){
        Collection<Category> categoryList=categoryService.getAllCategory();
        ActionContext.getContext().put("categoryList",categoryList);
        return "findAll";
    }
    public String save(){
        categoryService.saveCategory(this.getModel());
        return "saveSuccess";
    }
    public String delete(){
        category=categoryService.getCategoryById(this.getModel().getCid());
        categoryService.deleteCatory(category.getCid(), DeleteMode.DEL_PRE_RELEASE);
        return "deleteSuccess";
    }
    public String edit(){
        category=categoryService.getCategoryById(this.getModel().getCid());
        return "editSuccess";
    }
    public String update(){
        categoryService.updateCatory(category);
        return "updateSuccess";
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
