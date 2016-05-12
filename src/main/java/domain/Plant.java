package domain;

import java.io.Serializable;

/**
 * Created by lily on 2016/5/10.
 */
public class Plant implements Serializable{
    private Long pid;
    private String name;
    private Farm farm;

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

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }
}
