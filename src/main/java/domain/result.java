package domain;

import java.io.Serializable;

/**
 * Created by lily on 2016/5/17.
 */
public class result implements Serializable{
    private Long rid;
    private Long oid;
    private Long pid;
    private int state;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
