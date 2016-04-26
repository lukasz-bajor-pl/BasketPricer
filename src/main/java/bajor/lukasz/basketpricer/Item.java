package bajor.lukasz.basketpricer;

import java.math.BigDecimal;

/**
 * Created by lbajor on 2016-04-26.
 */
public enum Item {
    Apple {
        private final BigDecimal price = BigDecimal.valueOf(35, 2);

        @Override
        public BigDecimal getPrice() {
            return price;
        }
    };

    public abstract BigDecimal getPrice();
}
