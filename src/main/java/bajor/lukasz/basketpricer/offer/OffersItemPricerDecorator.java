package bajor.lukasz.basketpricer.offer;

import bajor.lukasz.basketpricer.Item;
import bajor.lukasz.basketpricer.ItemPricer;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by lbajor on 2016-04-27.
 */
public class OffersItemPricerDecorator implements ItemPricer {
    private final ItemPricer subPricer;

    public OffersItemPricerDecorator(Set<Offer> offers, ItemPricer subPricer) {

        this.subPricer = subPricer;
    }

    @Override
    public BigDecimal getPrice(Item item, long quantity) {
        //return subPricer.getPrice(item, quantity);
        return null;
    }
}
