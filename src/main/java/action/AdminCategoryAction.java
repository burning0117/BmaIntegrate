package action;

import com.opensymphony.xwork2.ActionContext;
import domain.Category;
import org.apache.struts2.components.Bean;
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
    public String getAllCategory(){
        Collection<Category> categoryList=categoryService.getAllCategory();
        ActionContext.getContext().put("categoryList",categoryList);
        return listAction;
    }
    public String add(){
        Category category=new Category();
        BeanUtils.copyProperties(this.getModel(),category);
        this.categoryService.saveCategory(category);
        return action2action;
    }
    public String deleteAdminCategory(){
        this.categoryService.deleteCatory(this.getModel().getCid(), DeleteMode.DEL_PRE_RELEASE);
        return action2action;
    }
    public String edit(){
        Category category=categoryService.getCategoryById(this.getModel().getCid());
        return "editSuccess";
    }
    public String update(){
        Category category=this.categoryService.getCategoryById(this.getModel().getCid());
        BeanUtils.copyProperties(this.getModel(),category);
        this.categoryService.updateCatory(category);
        return action2action;
    }
}
