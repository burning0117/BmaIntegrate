package service;

import dao.PreuserDao;
import domain.Preuser;
import org.springframework.stereotype.Service;
import utils.MailUitls;
import utils.PageBean;
import utils.UUIDUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lily on 2016/4/25.
 */
@Service("preuserService")
public class PreUserServiceImpl implements PreuserService{
    @Resource(name = "preuserDao")
    private PreuserDao preuserDao;
    public Preuser findByUserName(String username) {
        return this.preuserDao.getUserByName(username);
    }

    public void savePreuser(Preuser preuser) {
        preuser.setState((long) 0);
        String code= UUIDUtils.getUUID()+UUIDUtils.getUUID();
        preuser.setCode(code);
        preuserDao.saveEntry(preuser);
        MailUitls.sendMail(preuser.getEmail(), code);
    }

    public void updatePreuser(Preuser preuser) {
       this.preuserDao.updateEntry(preuser);
    }

    public Preuser findByCode(String code) {
        return this.preuserDao.findByCode(code);
    }

    public Preuser login(Preuser preuser) {
        return this.preuserDao.login(preuser);
    }

    public PageBean<Preuser> findByPage(Integer page) {
        PageBean<Preuser> pageBean=new PageBean<Preuser>();
        pageBean.setPage(page);
        int limit=5;
        pageBean.setLimit(limit);
        int totalCount=0;
        totalCount=preuserDao.findCount();
        pageBean.setTotalCount(totalCount);
        int totalPage=0;
        if (totalCount%limit==0){
            totalPage=totalCount/limit;
        }else {
            totalPage=totalCount/limit+1;
        }
        pageBean.setTotalPage(totalPage);
        int begin=(page-1)*limit;
        List<Preuser> list=preuserDao.findByPage(begin,limit);
        pageBean.setList(list);
        return pageBean;
    }

    public Preuser findByUid(Integer uid) {
        return (Preuser) preuserDao.getEntryById(uid);
    }

    public void deletePreuser(Preuser existPreuser) {
        this.preuserDao.deleteEntry(existPreuser);
    }
}
