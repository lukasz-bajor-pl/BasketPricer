package bajor.lukasz.basketpricer;

import bajor.lukasz.basketpricer.BasketImpl;
import bajor.lukasz.basketpricer.BasketPricer;
import bajor.lukasz.basketpricer.SimpleBasketPricer;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by lbajor on 2016-04-26.
 */
public class SimpleBasketPricerShould {
    SimpleBasketPricer basketPricer;

    @Before
    public void beforeTests() {
        basketPricer = new SimpleBasketPricer();
    }

    @Test
    public void returnZeroPriceForEmptyBasket() {
        assertThat(basketPricer.getPrice(new BasketImpl()), equalTo(BigDecimal.ZERO));
    }
}
