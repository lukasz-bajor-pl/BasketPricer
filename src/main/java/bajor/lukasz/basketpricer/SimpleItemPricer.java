package bajor.lukasz.basketpricer;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

/**
 * Created by lbajor on 2016-04-27.
 */
public class SimpleItemPricer implements ItemPricer {
    @Override
    public BigDecimal getPrice(Item item, long quantity) {
        if (quantity == 0) {
            return ZERO;
        }

        return item.price.multiply(new BigDecimal(quantity));
    }
}
