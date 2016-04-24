package domain;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by lily on 2016/4/22.
 */
public class CategorySecond implements Serializable{
    private Long csid;
    private String csname;
    private Category category;
    private Set<Production> productionList;

    public Long getCsid() {
        return csid;
    }

    public void setCsid(Long csid) {
        this.csid = csid;
    }

    public String getCsname() {
        return csname;
    }

    public void setCsname(String csname) {
        this.csname = csname;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Production> getProductionList() {
        return productionList;
    }

    public void setProductionList(Set<Production> productionList) {
        this.productionList = productionList;
    }
}
