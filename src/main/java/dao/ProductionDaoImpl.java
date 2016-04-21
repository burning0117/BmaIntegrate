package dao;

import domain.Production;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by lily on 2016/4/5.
 */
@Repository("productionDao")
public class ProductionDaoImpl extends BaseDaoImpl<Production> implements ProductionDao<Production>{

}
