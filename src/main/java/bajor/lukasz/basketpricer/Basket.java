package bajor.lukasz.basketpricer;

import java.util.Map;

/**
 * Created by lbajor on 2016-04-26.
 */
public interface Basket {
    Map<Item, Long> getItems();
}
