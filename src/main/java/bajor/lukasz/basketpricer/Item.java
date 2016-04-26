package bajor.lukasz.basketpricer;

import java.math.BigDecimal;

/**
 * Created by lbajor on 2016-04-26.
 */
public enum Item {
    Apple(BigDecimal.valueOf(35, 2)),
    Banana(BigDecimal.valueOf(20, 2)),
    Melon(BigDecimal.valueOf(50, 2)),
    Lime(BigDecimal.valueOf(15, 2));

    public final BigDecimal price;

    private Item(final BigDecimal price) {
        this.price = price;
    }
}
