package bajor.lukasz.basketpricer.offer;

import bajor.lukasz.basketpricer.Item;
import bajor.lukasz.basketpricer.ItemPricer;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by lbajor on 2016-04-27.
 */
public class OffersItemPricerDecorator implements ItemPricer {
    private final Set<Offer> offers;
    private final ItemPricer subPricer;

    public OffersItemPricerDecorator(Set<Offer> offers, ItemPricer subPricer) {
        this.offers = offers;

        this.subPricer = subPricer;
    }

    @Override
    public BigDecimal getPrice(Item item, long quantity) {
        BigDecimal basePrice = subPricer.getPrice(item, quantity);

        if (offers.isEmpty()) {
            return basePrice;
        }

        Offer offer = offers.iterator().next();
        return basePrice.subtract(offer.getDiscount());
    }
}
