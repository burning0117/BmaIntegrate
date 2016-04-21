package dao;

import domain.Seller;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by lily on 2016/4/5.
 */
@Repository("sellerDao")
public class SellerDaoImpl extends BaseDaoImpl<Seller> implements SellerDao<Seller>{

}
