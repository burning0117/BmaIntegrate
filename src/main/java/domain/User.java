package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by lily on 2016/4/10.
 */
public class User implements Serializable{
    private Long uid;
    private String name;
    private String password;
    private String email;
    private String address;
    private String phone;
    private BigDecimal ureputation;
    private Set<Good> good;

    public Set<Good> getGood() {
        return good;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public void setGood(Set<Good> good) {
        this.good = good;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public BigDecimal getUreputation() {
        return ureputation;
    }

    public void setUreputation(BigDecimal ureputation) {
        this.ureputation = ureputation;
    }
}
