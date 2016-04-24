package action;

import com.opensymphony.xwork2.ActionContext;
import domain.Category;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.CategoryService;
import service.ProductionService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lily on 2016/4/25.
 */
@Controller("indexAction")
@Scope("prototype")
public class IndexAction extends BaseAction<Category>{
    @Resource(name = "categoryService")
    private CategoryService categoryService;
    @Resource(name = "productionService")
    private ProductionService productionService;
    public String execute(){
        List<Category> categoryList= (List<Category>) categoryService.getAllCategory();
        ActionContext.getContext().getSession().put("categoryList",categoryList);
//        List<Production> hotList=productionService
        return null;
    }
//    @Resource(name = "index")
}
