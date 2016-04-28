package domain;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by lily on 2016/4/22.
 */
public class Category implements Serializable{
    private Long cid;
    private String cname;
    private Set<CategorySecond> categorySeconds;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Set<CategorySecond> getCategorySeconds() {
        return categorySeconds;
    }

    public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
        this.categorySeconds = categorySeconds;
    }
}
