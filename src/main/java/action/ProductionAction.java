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
    private Integer csid;
    private Integer cid;
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

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getAllProduction() {
        Collection<Production> productionList = this.productionService.getAllProductions();
        ActionContext.getContext().put("productionList", productionList);
        return listAction;
    }

    public String deleteProduction() {
        this.productionService.deleteProduction(this.getModel().getPid(), DeleteMode.DEL_PRE_RELEASE);
        return action2action;
    }

    public String addUI() {
        Collection<Seller> sellerList = this.sellerService.getAllSeller();
        ActionContext.getContext().put("sellerList", sellerList);
        return addUI;
    }

    public String add() {
        Production production = new Production();
        BeanUtils.copyProperties(this.getModel(), production);
        Seller seller=this.sellerService.getSellerById(this.sid);
        production.setSeller(seller);
        this.productionService.saveProduction(production);
        return action2action;
    }

    public String updateUI() {
        Collection<Seller> sellerList = this.sellerService.getAllSeller();
        Production production = this.productionService.getProductionById(this.getModel().getPid());
        ActionContext.getContext().getValueStack().getRoot().add(0, production);
//        ActionContext.getContext().put("production",production);
        ActionContext.getContext().put("sellerList", sellerList);
//        ActionContext.getContext().getValueStack().getRoot().add(1, sellerList);
        return updateUI;
    }

    public String update() {
        Production production = this.productionService.getProductionById(this.getModel().getPid());
        BeanUtils.copyProperties(this.getModel(), production);
        Seller seller=this.sellerService.getSellerById(this.sid);
        production.setSeller(seller);
        this.productionService.updateProduction(production);
        return action2action;
    }
    public String findByPid(){
        production=productionService.getProductionById(production.getPid());
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
