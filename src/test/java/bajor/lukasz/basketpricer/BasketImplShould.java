package bajor.lukasz.basketpricer;

import org.junit.Test;

import java.util.Map;

import static bajor.lukasz.basketpricer.Item.Apple;
import static bajor.lukasz.basketpricer.Item.Banana;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasSize;


/**
 * Created by lbajor on 2016-04-27.
 */
public class BasketImplShould {
    @Test
    public void returnNoItemsOnEmptyBasket() {
        assertThat(new BasketImpl().getItems().keySet(), hasSize(0));
    }

    @Test
    public void returnOneItemFromOneElementBasket() {
        Map<Item, Long> items = new BasketImpl(Apple).getItems();
        assertThat(items.keySet(), hasSize(1));
        assertThat(items, hasEntry(Apple, 1L));
    }

    @Test
    public void returnTwoItemsFromTwoApplesBasket() {
        Map<Item, Long> items = new BasketImpl(Apple, Apple).getItems();
        assertThat(items.keySet(), hasSize(1));
        assertThat(items, hasEntry(Apple, 2L));
    }

    @Test
    public void returnManyItemsFromManyItemsInBasket() {
        Map<Item, Long> items = new BasketImpl(Apple, Apple, Banana, Banana, Banana).getItems();
        assertThat(items.keySet(), hasSize(2));
        assertThat(items, hasEntry(Apple, 2L));
        assertThat(items, hasEntry(Banana, 3L));
    }
}