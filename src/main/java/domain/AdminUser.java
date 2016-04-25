package domain;

import java.io.Serializable;

/**
 * Created by lily on 2016/4/25.
 */
public class AdminUser implements Serializable{
    private Long auid;
    private String username;
    private String password;

    public Long getAuid() {
        return auid;
    }

    public void setAuid(Long auid) {
        this.auid = auid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
