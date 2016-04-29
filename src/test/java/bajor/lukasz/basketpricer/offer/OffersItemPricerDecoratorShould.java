package bajor.lukasz.basketpricer.offer;

import bajor.lukasz.basketpricer.Item;
import bajor.lukasz.basketpricer.ItemPricer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;

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
}