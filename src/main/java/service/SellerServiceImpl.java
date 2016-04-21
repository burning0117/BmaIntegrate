package service;

import dao.SellerDao;
import domain.Seller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by lily on 2016/4/5.
 */
@Service("sellerService")
public class SellerServiceImpl implements SellerService {
    @Resource(name = "sellerDao")
    private SellerDao sellerDao;
    @Transactional(readOnly = false)
    public void saveSeller(Seller seller) {
        this.sellerDao.saveEntry(seller);
    }
    @Transactional(readOnly = false)
    public void deleteSeller(Serializable id, String deleteMode) {
        this.sellerDao.deleteEntry(id);
    }
    @Transactional(readOnly = false)
    public void updateSeller(Seller seller) {
        this.sellerDao.updateEntry(seller);
    }

    public Collection<Seller> getAllSeller() {
        return this.sellerDao.getAllEntry();
    }

    public Seller getSellerById(Serializable id) {
        return (Seller) this.sellerDao.getEntryById(id);
    }
}
