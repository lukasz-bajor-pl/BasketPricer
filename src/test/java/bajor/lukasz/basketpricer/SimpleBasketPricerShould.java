package bajor.lukasz.basketpricer;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static bajor.lukasz.basketpricer.Item.Apple;
import static bajor.lukasz.basketpricer.Item.Banana;
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

    @Test
    public void returnUnitPriceOfApple() {
        BasketImpl basket = new BasketImpl(Apple);
        assertThat(basketPricer.getPrice(basket), equalTo(Apple.price));
    }

    @Test
    public void returnSumOfUnitPricesOfApplesAndBananas() {
        BasketImpl basket = new BasketImpl(Apple, Apple, Banana);
        assertThat(basketPricer.getPrice(basket), equalTo(Apple.price.multiply(new BigDecimal(2)).add(Banana.price)));
    }
}
