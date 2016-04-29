package bajor.lukasz.basketpricer.offer;

import bajor.lukasz.basketpricer.Item;
import com.google.common.base.Preconditions;

import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by lbajor on 2016-04-27.
 */
public class BulkBuyOffer implements Offer {
    private final Item item;
    private final long requiredQuantity;
    private final long payForQuantity;

    public BulkBuyOffer(Item item, long requiredQuantity, long payForQuantity) {
        this.item = item;
        this.requiredQuantity = requiredQuantity;
        this.payForQuantity = payForQuantity;

        checkArgument(requiredQuantity > payForQuantity, "Expect offer to reduce price!");
    }

    @Override
    public Item getItem() {
        return item;
    }

    @Override
    public long getQuantityRequired() {
        return requiredQuantity;
    }

    @Override
    public BigDecimal getDiscount() {
        return item.price.multiply(new BigDecimal(requiredQuantity - payForQuantity));
    }
}
