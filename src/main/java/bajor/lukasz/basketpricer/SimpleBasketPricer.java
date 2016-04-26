package bajor.lukasz.basketpricer;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by lbajor on 2016-04-26.
 */
public class SimpleBasketPricer implements BasketPricer {
    private final ItemPricer itemPricer;

    public SimpleBasketPricer(ItemPricer itemPricer) {

        this.itemPricer = itemPricer;
    }

    @Override
    public BigDecimal getPrice(Basket basket) {
        Map<Item, Long> items = basket.getItems();

        BigDecimal result = BigDecimal.ZERO;

        for (Item i: items.keySet()) {
            result = result.add(itemPricer.getPrice(i, items.get(i)));
        }

        return result;
    }
}
