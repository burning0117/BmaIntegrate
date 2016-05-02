package action;

import com.opensymphony.xwork2.ActionContext;
import domain.Production;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.ProductionService;
import service.SellerService;
import utils.PageBean;

import javax.annotation.Resource;

/**
 * Created by lily on 2016/4/5.
 */
@Controller("productionAction")
@Scope("prototype")
public class ProductionAction extends BaseAction<Production>{
    @Resource(name = "productionService")
    private ProductionService productionService;
    @Resource(name = "sellerService")
    private SellerService sellerService;
    private Long sid;
    private Long csid;
    private Long cid;
    private int page;
    private Production production=new Production();
    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getCsid() {
        return csid;
    }

    public void setCsid(Long csid) {
        this.csid = csid;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String findByPid(){
        production=this.productionService.getProductionById(this.getModel().getPid());
        ActionContext.getContext().getValueStack().set("production", production);
        return "findByPid";
    }
    public String findByCid(){
        PageBean<Production> pageBean=this.productionService.getProductionByPageCid(cid, page);
        ActionContext.getContext().getValueStack().set("pageBean",pageBean);
        return "findByCid";
    }
    public String findByCsid(){
        PageBean<Production> pageBean=this.productionService.getProductionByPageCsid(csid,page);
        ActionContext.getContext().getValueStack().set("pageBean",pageBean);
        return "findByCsid";
    }

}
