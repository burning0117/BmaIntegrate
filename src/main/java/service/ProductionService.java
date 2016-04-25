package service;

import domain.Production;
import utils.PageBean;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by lily on 2016/4/5.
 */
public interface ProductionService{
    public void saveProduction(Production production);
    public void deleteProduction(Serializable id, String deleteMode);
    public void updateProduction(Production production);
    public Collection<Production> getAllProductions();
    public Production getProductionById(Serializable id);
    public PageBean<Production> getProductionByPageCid(Integer id,int page);
    public PageBean<Production> getProductionByPageCsid(Integer csid,int page);
    public PageBean<Production> getProductionByPage(Integer page);
}
