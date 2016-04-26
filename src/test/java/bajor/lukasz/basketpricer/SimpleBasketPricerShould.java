package bajor.lukasz.basketpricer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static bajor.lukasz.basketpricer.Item.Apple;
import static bajor.lukasz.basketpricer.Item.Banana;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by lbajor on 2016-04-26.
 */
@RunWith(MockitoJUnitRunner.class)
public class SimpleBasketPricerShould {
    @Mock
    ItemPricer pricer;

    @InjectMocks
    SimpleBasketPricer basketPricer;

    @Before
    public void beforeTests() {
        when(pricer.getPrice(Apple, 1L)).thenReturn(Apple.price);
        when(pricer.getPrice(Banana, 1L)).thenReturn(Banana.price);
    }

    @Test
    public void returnZeroPriceForEmptyBasket() {
        Mockito.verifyZeroInteractions(pricer);
        assertThat(basketPricer.getPrice(new BasketImpl()), equalTo(BigDecimal.ZERO));
    }

    @Test
    public void returnUnitPriceOfApple() {
        BasketImpl basket = new BasketImpl(Apple);

        assertThat(basketPricer.getPrice(basket), equalTo(Apple.price));

        verify(pricer).getPrice(Apple, 1L);
    }

    @Test
    public void returnSumOfUnitPricesOfApplesAndBananas() {
        when(pricer.getPrice(Apple, 2L)).thenReturn(Apple.price.multiply(new BigDecimal(2)));

        BasketImpl basket = new BasketImpl(Apple, Apple, Banana);
        assertThat(basketPricer.getPrice(basket), equalTo(Apple.price.multiply(new BigDecimal(2)).add(Banana.price)));

        verify(pricer).getPrice(Apple, 2L);
        verify(pricer).getPrice(Banana, 1L);
    }
}
