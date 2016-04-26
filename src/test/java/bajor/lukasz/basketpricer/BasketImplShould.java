package bajor.lukasz.basketpricer;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;


/**
 * Created by lbajor on 2016-04-27.
 */
public class BasketImplShould {
    @Test
    public void returnNoItemsOnEmptyBasket() {
        assertThat(new BasketImpl().getItems().keySet(), hasSize(0));
    }
}