package bajor.lukasz.basketpricer;

import java.math.BigDecimal;

/**
 * Created by lbajor on 2016-04-26.
 */
public class SimpleBasketPricer implements BasketPricer {
    @Override
    public BigDecimal getPrice(Basket basket) {
        return BigDecimal.ZERO;
    }
}
