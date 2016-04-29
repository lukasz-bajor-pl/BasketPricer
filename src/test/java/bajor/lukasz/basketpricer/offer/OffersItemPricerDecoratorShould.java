package bajor.lukasz.basketpricer.offer;

import bajor.lukasz.basketpricer.Item;
import bajor.lukasz.basketpricer.ItemPricer;
import bajor.lukasz.basketpricer.SimpleItemPricer;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;

import static bajor.lukasz.basketpricer.Item.Apple;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

/**
 * Created by lbajor on 2016-04-30.
 */
@RunWith(MockitoJUnitRunner.class)
public class OffersItemPricerDecoratorShould {
    @Mock
    ItemPricer subPricerMock;

    OffersItemPricerDecorator withOffersPricer;

    @Test
    public void callSubPricerForPriceCalculation() {
        withOffersPricer = new OffersItemPricerDecorator(Collections.emptySet(), subPricerMock);
        withOffersPricer.getPrice(Apple, 3);

        verify(subPricerMock).getPrice(Apple, 3);
    }

    @Test
    public void applyOfferForSameItem() {
        withOffersPricer = new OffersItemPricerDecorator(new HashSet<Offer>() {
            {
                add(new BulkBuyOffer(Apple, 2, 1));
            }
        }, new SimpleItemPricer());

        assertThat(withOffersPricer.getPrice(Apple, 3), equalTo(Apple.price.multiply(new BigDecimal(2))));
    }

    @Test
    public void applyOnlyOfferForThisItem() {
        withOffersPricer = new OffersItemPricerDecorator(new HashSet<Offer>() {
            {
                add(new BulkBuyOffer(Apple, 2, 1));
            }
        }, new SimpleItemPricer());

        int bananasQuantity = 3;
        Assert.assertThat(withOffersPricer.getPrice(Item.Banana, bananasQuantity), CoreMatchers.equalTo(Item.Banana.price.multiply(new BigDecimal(bananasQuantity))));
    }

    @Test
    public void applyOfferMoreThanOnceIfPossible() {
        withOffersPricer = new OffersItemPricerDecorator(new HashSet<Offer>() {
            {
                add(new BulkBuyOffer(Apple, 2, 1));
            }
        }, new SimpleItemPricer());

        assertThat(withOffersPricer.getPrice(Apple, 6), equalTo(Apple.price.multiply(new BigDecimal(3))));
    }
}