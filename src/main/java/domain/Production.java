package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by lily on 2016/4/3.
 */
public class Production implements Serializable {
    private Long pid;
    private String pname;
    private Double market_price;
    private Double shop_price;
    private BigDecimal price;
    private BigDecimal pricerate;
    private BigDecimal preputation;
    private BigDecimal preputationrate;
    private BigDecimal pqos;
    private String image;
    private Integer core;//CPU核心数
    private Double ram;//内存大小
    private Double disk;//磁盘大小
    private Double priceHour;//云服务或批处理每小时话费的金钱
    private String pdesc;
    private Seller seller;
    private Integer is_hot;
    private Date pdate;
    private CategorySecond categorySecond;

    public Double getPriceHour() {
        return priceHour;
    }

    public void setPriceHour(Double priceHour) {
        this.priceHour = priceHour;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getCore() {
        return core;
    }

    public void setCore(Integer core) {
        this.core = core;
    }

    public Double getRam() {
        return ram;
    }

    public void setRam(Double ram) {
        this.ram = ram;
    }

    public Double getDisk() {
        return disk;
    }

    public void setDisk(Double disk) {
        this.disk = disk;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getMarket_price() {
        return market_price;
    }

    public void setMarket_price(Double market_price) {
        this.market_price = market_price;
    }

    public Double getShop_price() {
        return shop_price;
    }

    public void setShop_price(Double shop_price) {
        this.shop_price = shop_price;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Integer getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(Integer is_hot) {
        this.is_hot = is_hot;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public CategorySecond getCategorySecond() {
        return categorySecond;
    }

    public void setCategorySecond(CategorySecond categorySecond) {
        this.categorySecond = categorySecond;
    }
}
