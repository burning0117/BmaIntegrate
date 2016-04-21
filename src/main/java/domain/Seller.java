package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by lily on 2016/4/3.
 */
public class Seller implements Serializable{
    private Long sid;
    private String name;
    private String password;
    private String description;
    private String phone;
    private BigDecimal sreputation;
    private String address;
    private Set<Production> production;

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getSreputation() {
        return sreputation;
    }

    public void setSreputation(BigDecimal sreputation) {
        this.sreputation = sreputation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Production> getProduction() {
        return production;
    }

    public void setProduction(Set<Production> production) {
        this.production = production;
    }
}
