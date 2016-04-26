package bajor.lukasz.basketpricer;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * Created by lbajor on 2016-04-27.
 */
public class SimpleItemPricerShould {
    SimpleItemPricer pricer = new SimpleItemPricer();

    @Test
    public void return0IfQuantityIs0() {
        assertThat(pricer.getPrice(Item.Apple, 0), Matchers.equalTo(0));
    }
}