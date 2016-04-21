package service;

import dao.ProductionDao;
import domain.Production;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by lily on 2016/4/5.
 */
@Service("productionService")
public class ProductionServiceImpl implements ProductionService {
    @Resource(name = "productionDao")
    private ProductionDao productionDao;

    @Transactional(readOnly = false)
    public void saveProduction(Production production) {
        this.productionDao.saveEntry(production);
    }

    @Transactional(readOnly = false)
    public void deleteProduction(Serializable id, String deleteMode) {
        this.productionDao.deleteEntry(id);
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
}
