package domain;

import java.io.Serializable;

/**
 * Created by lily on 2016/4/25.
 */
public class CartItem implements Serializable{
    private Production production;
    private int count;
    private double subtotal;

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        this.production = production;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
