package bajor.lukasz.basketpricer;

import java.math.BigDecimal;

/**
 * Created by lbajor on 2016-04-27.
 */
public interface ItemPricer {
    public BigDecimal getPrice(Item item, long quantity);
}
