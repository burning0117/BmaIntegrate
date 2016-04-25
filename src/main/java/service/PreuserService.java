package service;

import domain.Preuser;
import utils.PageBean;

/**
 * Created by lily on 2016/4/25.
 */
public interface PreuserService{
    public Preuser findByUserName(String username);
    public void savePreuser(Preuser preuser);
    public void updatePreuser(Preuser preuser);
    public Preuser findByCode(String code);
    public Preuser login(Preuser preuser);
    public PageBean<Preuser> findByPage(Integer page);
    public Preuser findByUid(Integer uid);
    public void deletePreuser(Preuser existPreuser);
}
