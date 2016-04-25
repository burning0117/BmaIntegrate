package action;

import com.opensymphony.xwork2.ActionContext;
import domain.CategorySecond;
import domain.Production;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.CategorySecondService;
import service.ProductionService;
import utils.DeleteMode;
import utils.PageBean;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by lily on 2016/4/25.
 */
@Controller("adminProductionAction")
@Scope("prototype")
public class AdminProductionAction extends BaseAction<Production> {
    @Resource(name = "productionService")
    private ProductionService productionService;
    @Resource(name = "categorySecondService")
    private CategorySecondService categorySecondService;
    private Production production;
    private Integer page;
    private File upload;
    private String uploadFileName;
    private String uploadContentType;

    public String findAll() {
        PageBean<Production> pageBean = productionService.getProductionByPage(page);
        ActionContext.getContext().getValueStack().set("pageBean", pageBean);
        return "findAll";
    }

    public String addPage() {
        List<CategorySecond> categorySecondList=categorySecondService.getAllCategorySecond();
        ActionContext.getContext().getValueStack().set("csList", categorySecondList);
        return "addPageSuccess";
    }
    public String save() throws IOException {
        production.setDate(new Date());
        if (upload!=null){
            String path= ServletActionContext.getServletContext().getRealPath("/products");
            File diskFile=new File(path+"//"+uploadFileName);
            FileUtils.copyFile(upload,diskFile);
            production.setImage("products/"+uploadFileName);
        }
        productionService.saveProduction(production);
        return "saveSuccess";
    }
    public String delete(){
        production=productionService.getProductionById(production.getPid());
        String path= ServletActionContext.getServletContext().getRealPath("/"+production.getImage());
        File file=new File(path);
        file.delete();
        productionService.deleteProduction(production, DeleteMode.DEL_PRE_RELEASE);
        return "deleteSuccess";
    }
    public String edit(){
        production=productionService.getProductionById(production.getPid());
        List<CategorySecond> categorySecondList=categorySecondService.getAllCategorySecond();
        ActionContext.getContext().getValueStack().set("csList", categorySecondList);
        return "editSuccess";
    }
    public String update() throws IOException {
        production.setPdate(new Date());
        if (upload!=null){
            String delpath= ServletActionContext.getServletContext().getRealPath("/"+production.getImage());
            File file=new File(delpath);
            file.delete();
            String path=ServletActionContext.getServletContext().getRealPath("/products");
            File diskFile=new File(path+"//"+uploadFileName);
            FileUtils.copyFile(upload,diskFile);
            production.setImage("products/"+uploadFileName);
        }
        productionService.updateProduction(production);
        return "updateSuccess";
    }
    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        this.production = production;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }
}
