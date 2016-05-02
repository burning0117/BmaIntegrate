package service;

import dao.ProductionDao;
import domain.Production;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utils.PageBean;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by lily on 2016/4/5.
 */
@Service("productionService")
public class ProductionServiceImpl implements ProductionService {
    @Resource(name = "productionDao")
    private ProductionDao productionDao;

    public List<Production> findNew() {
        return this.productionDao.findNew();
    }

    public List<Production> findHot() {
        return this.productionDao.findHot();
    }

    @Transactional(readOnly = false)
    public void saveProduction(Production production) {
        this.productionDao.saveEntry(production);
    }

    @Transactional(readOnly = false)
    public void deleteProduction(Production production) {
        this.productionDao.deleteEntry(production);
    }

    @Transactional(readOnly = false)
    public void updateProduction(Production production) {
        this.productionDao.updateEntry(production);
    }

    public Collection<Production> getAllProductions() {
        return this.productionDao.getAllEntry();
    }

    public Production getProductionById(Serializable id) {
        return (Production) this.productionDao.getEntryById(id);
    }

    public PageBean<Production> getProductionByPageCid(Long id, int page) {
        PageBean<Production> pageBean=new PageBean<Production>();
        pageBean.setPage(page);
        int limit=8;
        pageBean.setLimit(limit);
        int totalCount=0;
        totalCount=productionDao.findCountCid(id);
        pageBean.setTotalCount(totalCount);
        int totalPage=0;
        if (totalCount%limit==0){
            totalPage=totalCount/limit;
        }else {
            totalPage=totalCount/limit+1;
        }
        pageBean.setTotalPage(totalPage);
        int begin=(page-1)*limit;
        List<Production> list=this.productionDao.findByPageCid(id, begin, limit);
        pageBean.setLimit(limit);
        return pageBean;
    }

    public PageBean<Production> getProductionByPageCsid(Long csid, int page) {
        PageBean<Production> pageBean=new PageBean<Production>();
        pageBean.setPage(page);
        int limit=8;
        pageBean.setLimit(limit);
        int totalCount=0;
        totalCount=this.productionDao.findCountCsid(csid);
        pageBean.setTotalPage(totalCount);
        int totalPage=0;
        if (totalCount%limit==0){
            totalPage=totalCount/limit;
        }else {
            totalPage=totalCount/limit+1;
        }
        pageBean.setTotalPage(totalPage);
        int begin=(page-1)*limit;
        List<Production> list=this.productionDao.findBypageCsid(csid,begin,limit);
        pageBean.setList(list);
        return pageBean;
    }

    public PageBean<Production> getProductionByPage(int page) {
        PageBean<Production> pageBean=new PageBean<Production>();
        pageBean.setPage(page);
        int limit=10;
        pageBean.setLimit(limit);
        int totalCount=0;
        totalCount=this.productionDao.findCount();
        pageBean.setTotalCount(totalCount);
        int totalPage=0;
        if (totalCount%limit==0){
            totalPage=totalCount/limit;
        }else {
            totalPage=totalCount/limit+1;
        }
        pageBean.setTotalPage(totalPage);
        int begin=(page-1)*limit;
        List<Production> list=productionDao.findByPage(begin,limit);
        pageBean.setList(list);
        return pageBean;
    }
}
