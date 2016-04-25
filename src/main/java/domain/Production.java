package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by lily on 2016/4/3.
 */
public class Production implements Serializable {
    private Long pid;
    private String name;
    private BigDecimal price;
    private BigDecimal pricerate;
    private BigDecimal preputation;
    private BigDecimal preputationrate;
    private BigDecimal pqos;
    private String image;
    private Seller seller;
    private Date pdate;
    private CategorySecond categorySecond;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDate() {
        return pdate;
    }

    public void setDate(Date pdate) {
        this.pdate = pdate;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public CategorySecond getCategorySecond() {
        return categorySecond;
    }

    public void setCategorySecond(CategorySecond categorySecond) {
        this.categorySecond = categorySecond;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPricerate() {
        return pricerate;
    }

    public void setPricerate(BigDecimal pricerate) {
        this.pricerate = pricerate;
    }

    public BigDecimal getPreputation() {
        return preputation;
    }

    public void setPreputation(BigDecimal preputation) {
        this.preputation = preputation;
    }

    public BigDecimal getPreputationrate() {
        return preputationrate;
    }

    public void setPreputationrate(BigDecimal preputationrate) {
        this.preputationrate = preputationrate;
    }

    public BigDecimal getPqos() {
        return pqos;
    }

    public void setPqos(BigDecimal pqos) {
        this.pqos = pqos;
    }

}
