package service;

import domain.Production;

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
}
