package bajor.lukasz.basketpricer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lbajor on 2016-04-26.
 */
public class BasketImpl implements Basket {
    private final Map<Item, Long> items = new HashMap<>();

    public BasketImpl() {
    }

    public BasketImpl(Item item) {
        this.items.put(item, 1L);
    }

    public BasketImpl(Item... items) {
        for (Item i: items) {
            this.items.merge(i, 1L, (prevVal, newVal) -> prevVal + newVal);
        }
    }

    @Override
    public Map<Item, Long> getItems() {
        return Collections.unmodifiableMap(items);
    }
}
