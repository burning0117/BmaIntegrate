package dao;

import domain.Good;
import org.springframework.stereotype.Repository;

/**
 * Created by lily on 2016/4/3.
 */
@Repository("goodDao")
public class GoodDaoImpl extends BaseDaoImpl<Good> implements GoodDao<Good> {
}

