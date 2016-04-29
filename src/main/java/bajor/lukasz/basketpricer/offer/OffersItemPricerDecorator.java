package bajor.lukasz.basketpricer.offer;

import bajor.lukasz.basketpricer.Item;
import bajor.lukasz.basketpricer.ItemPricer;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

        final List<Offer> offersForItem = offers.stream().filter(o -> o.getItem().equals(item)).collect(Collectors.toList());

        if (offersForItem.isEmpty()) {
            return basePrice;
        }

        return basePrice.subtract(offersForItem.get(0).getDiscount());
    }
}
