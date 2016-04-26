package bajor.lukasz.basketpricer;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by lbajor on 2016-04-27.
 */
public class BasketPricerIntegrationTest {
    ItemPricer pricer = new SimpleItemPricer();
    BasketPricer basketPricer = new SimpleBasketPricer(pricer);

    @Test
    public void shouldCalculateIndividualPricesOfAllItemsInBasket() {
        Basket b = new BasketImpl(Item.Apple, Item.Apple, Item.Banana);

        assertEquals(Item.Apple.price.multiply(new BigDecimal(2)).add(Item.Banana.price), basketPricer.getPrice(b));
    }
}
