package action;

import com.opensymphony.xwork2.ActionContext;
import domain.Production;
import domain.Seller;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.ProductionService;
import service.SellerService;
import utils.DeleteMode;
import utils.PageBean;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by lily on 2016/4/5.
 */
@Controller("productionAction")
@Scope("prototype")
public class ProductionAction extends BaseAction<Production> {
    @Resource(name = "productionService")
    private ProductionService productionService;
    @Resource(name = "sellerService")
    private SellerService sellerService;
    private Long sid;
    private Long csid;
    private Long cid;
    private int page;
    private Production production;

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        this.production = production;
    }

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
        return "findByPid";
    }
    public String findByCid(){
        System.out.println(cid+"11111");
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
