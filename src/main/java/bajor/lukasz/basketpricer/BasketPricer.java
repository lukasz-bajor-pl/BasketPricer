package bajor.lukasz.basketpricer;

import java.math.BigDecimal;

/**
 * Created by lbajor on 2016-04-26.
 */
public interface BasketPricer {
    BigDecimal getPrice(Basket basket);
}
