package bajor.lukasz.basketpricer.offer;

import bajor.lukasz.basketpricer.Item;

import java.math.BigDecimal;

/**
 * Created by lbajor on 2016-04-27.
 */
public interface Offer {
    Item getItem();
    long getQuantityRequired();
    BigDecimal getDiscount();
}
