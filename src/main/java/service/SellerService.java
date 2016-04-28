package service;

import domain.Seller;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by lily on 2016/4/5.
 */
public interface SellerService{
    public void saveSeller(Seller seller);
    public void deleteSeller(Seller seller);
    public void updateSeller(Seller seller);
    public Collection<Seller> getAllSeller();
    public Seller getSellerById(Serializable id);
}
