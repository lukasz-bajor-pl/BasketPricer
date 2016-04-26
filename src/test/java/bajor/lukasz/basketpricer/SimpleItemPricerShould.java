package bajor.lukasz.basketpricer;

import org.junit.Test;

import static bajor.lukasz.basketpricer.Item.Apple;
import static java.math.BigDecimal.ZERO;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by lbajor on 2016-04-27.
 */
public class SimpleItemPricerShould {
    SimpleItemPricer pricer = new SimpleItemPricer();

    @Test
    public void return0IfQuantityIs0() {
        assertThat(pricer.getPrice(Apple, 0), equalTo(ZERO));
    }

    @Test
    public void returnItemUnitPriceIfQuantityIs1() {
        assertThat(pricer.getPrice(Apple, 1), equalTo(Apple.price));
    }
}