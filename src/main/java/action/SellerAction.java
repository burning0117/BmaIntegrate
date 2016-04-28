package action;

import com.opensymphony.xwork2.ActionContext;
import domain.Seller;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.SellerService;
import utils.DeleteMode;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by lily on 2016/4/5.
 */
@Controller("sellerAction")
@Scope("prototype")
public class SellerAction extends BaseAction<Seller> {
    @Resource(name = "sellerService")
    private SellerService sellerService;
    private String password2;

    public String getAllSeller() {
        Collection<Seller> sellerList = this.sellerService.getAllSeller();
        ActionContext.getContext().put("sellerList", sellerList);
        return listAction;
    }

    public String deleteSeller() {
        this.sellerService.deleteSeller(this.getModel());
        return action2action;
    }

    public String addUI() {
        return addUI;
    }

    public String add() {
        Seller seller = new Seller();
        BeanUtils.copyProperties(this.getModel(), seller);
        this.sellerService.saveSeller(seller);
        return action2action;
    }

    public String updateUI() {
        Seller seller = this.sellerService.getSellerById(this.getModel().getSid());
        ActionContext.getContext().getValueStack().getRoot().add(0, seller);
        return updateUI;
    }

    public String update() {
        Seller seller = this.sellerService.getSellerById(this.getModel().getSid());
        BeanUtils.copyProperties(this.getModel(), seller);
        this.sellerService.updateSeller(seller);
        return action2action;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getPassword2() {
        return password2;
    }
}
