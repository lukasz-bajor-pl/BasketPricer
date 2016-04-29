package bajor.lukasz.basketpricer;

import bajor.lukasz.basketpricer.offer.BulkBuyOffer;
import bajor.lukasz.basketpricer.offer.Offer;
import bajor.lukasz.basketpricer.offer.OffersItemPricerDecorator;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

/**
 * Created by lbajor on 2016-04-27.
 */
public class BasketPricerIntegrationTest {
    @Test
    public void shouldCalculateIndividualPricesOfAllItemsInBasket() {
        ItemPricer pricer = new SimpleItemPricer();
        BasketPricer basketPricer = new SimpleBasketPricer(pricer);

        Basket b = new BasketImpl(Item.Apple, Item.Apple, Item.Banana);

        assertEquals(Item.Apple.price.multiply(new BigDecimal(2)).add(Item.Banana.price), basketPricer.getPrice(b));
    }

    @Test
    public void shouldCalculatePricesOfBasketIncludingOffers() {
        ItemPricer pricer = new OffersItemPricerDecorator(new HashSet<Offer>() {
            {
                add(new BulkBuyOffer(Item.Melon, 2, 1));
                add(new BulkBuyOffer(Item.Lime, 3, 2));
            }
        }, new SimpleItemPricer());
        BasketPricer basketPricer = new SimpleBasketPricer(pricer);

        Basket b = new BasketImpl(Item.Apple, Item.Melon, Item.Melon, Item.Melon, Item.Melon, Item.Melon, Item.Lime, Item.Lime, Item.Lime);

        assertEquals(Item.Apple.price.add(Item.Melon.price.multiply(new BigDecimal(3))).add(Item.Lime.price.multiply(new BigDecimal(2))), basketPricer.getPrice(b));
    }
}
