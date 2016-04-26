package bajor.lukasz.basketpricer;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by lbajor on 2016-04-27.
 */
public class SimpleItemPricerShould {
    SimpleItemPricer pricer = new SimpleItemPricer();

    @Test
    public void return0IfQuantityIs0() {
        assertThat(pricer.getPrice(Item.Apple, 0), equalTo(BigDecimal.ZERO));
    }

    @Test
    public void returnItemUnitPriceIfQuantityIs1() {
        assertThat(pricer.getPrice(Item.Apple, 1), equalTo(Item.Apple.price));
    }
}