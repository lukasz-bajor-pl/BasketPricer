package bajor.lukasz.basketpricer;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by lbajor on 2016-04-26.
 */
public class SimpleBasketPricer implements BasketPricer {
    @Override
    public BigDecimal getPrice(Basket basket) {
        Map<Item, Long> items = basket.getItems();

        BigDecimal result = BigDecimal.ZERO;

        for (Item i: items.keySet()) {
            result = result.add(i.price);
        }

        return result;
    }
}
