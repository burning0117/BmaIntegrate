package domain;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by lily on 2016/5/10.
 */
public class Farm implements Serializable{
    private Long fid;
    private String name;
    private Set<Plant> plantSet;

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Plant> getPlantSet() {
        return plantSet;
    }

    public void setPlantSet(Set<Plant> plantSet) {
        this.plantSet = plantSet;
    }
}
