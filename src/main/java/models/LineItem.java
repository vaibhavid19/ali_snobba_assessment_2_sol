package models;

import java.math.BigDecimal;
import java.math.BigInteger;

public class LineItem {
    private Item item;
    private int quantity;

    public LineItem(Item item) {
        this.item = item;
        this.quantity = this.quantity+1 ;
    }

    public LineItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubTotal() {
        return this.item.getPrice().multiply(new BigDecimal(this.quantity));
    }
}
