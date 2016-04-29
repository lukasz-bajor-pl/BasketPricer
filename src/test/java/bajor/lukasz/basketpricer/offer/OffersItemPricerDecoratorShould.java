package bajor.lukasz.basketpricer.offer;

import bajor.lukasz.basketpricer.Item;
import bajor.lukasz.basketpricer.ItemPricer;
import bajor.lukasz.basketpricer.SimpleItemPricer;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;

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
        withOffersPricer.getPrice(Item.Apple, 3);

        Mockito.verify(subPricerMock).getPrice(Item.Apple, 3);
    }

    @Test
    public void applyOfferForSameItem() {
        withOffersPricer = new OffersItemPricerDecorator(new HashSet<Offer>() {
            {
                add(new BulkBuyOffer(Item.Apple, 2, 1));
            }
        }, new SimpleItemPricer());

        Assert.assertThat(withOffersPricer.getPrice(Item.Apple, 3), CoreMatchers.equalTo(Item.Apple.price.multiply(new BigDecimal(2))));
    }
}