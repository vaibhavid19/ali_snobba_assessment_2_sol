package models;

import java.math.BigDecimal;
import java.math.BigInteger;

public class LineItem {
    private Item item;
    private int quantity;
    private BigDecimal discountedPrice;

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

    public BigDecimal getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(float discountedPrice) {
        this.discountedPrice = item.getPrice().multiply(item.getDiscount());
    }
}
