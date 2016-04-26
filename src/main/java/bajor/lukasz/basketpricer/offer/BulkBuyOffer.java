package bajor.lukasz.basketpricer.offer;

import bajor.lukasz.basketpricer.Item;

import java.math.BigDecimal;

/**
 * Created by lbajor on 2016-04-27.
 */
public class BulkBuyOffer implements Offer {

    public BulkBuyOffer(Item item, long requiredQuantity, long payForQuantity) {
    }

    @Override
    public Item getItem() {
        return null;
    }

    @Override
    public long getQuantityRequired() {
        return 0;
    }

    @Override
    public BigDecimal getPrice() {
        return null;
    }
}
