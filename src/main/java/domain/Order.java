package domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by lily on 2016/4/3.
 */
public class Order implements Serializable {
    private Long oid;
    private String name;
    private BigDecimal price;
    private BigDecimal pricerate;
    private BigDecimal greputation;
    private BigDecimal greputationrate;
    private BigDecimal gqos;
    private BigDecimal gqosrate;
    private Preuser preuser;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
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

    public BigDecimal getGreputation() {
        return greputation;
    }

    public void setGreputation(BigDecimal greputation) {
        this.greputation = greputation;
    }

    public BigDecimal getGreputationrate() {
        return greputationrate;
    }

    public void setGreputationrate(BigDecimal greputationrate) {
        this.greputationrate = greputationrate;
    }

    public BigDecimal getGqos() {
        return gqos;
    }

    public void setGqos(BigDecimal gqos) {
        this.gqos = gqos;
    }

    public BigDecimal getGqosrate() {
        return gqosrate;
    }

    public void setGqosrate(BigDecimal gqosrate) {
        this.gqosrate = gqosrate;
    }

    public Preuser getPreuser() {
        return preuser;
    }

    public void setPreuser(Preuser preuser) {
        this.preuser = preuser;
    }
}