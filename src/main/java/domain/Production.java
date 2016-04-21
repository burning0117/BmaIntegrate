package domain;

import java.io.Serializable;
import java.math.BigDecimal;

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
    private Seller seller;

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

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
