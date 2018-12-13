package models;

import java.math.BigDecimal;

public class Item {
    private String name;
    private BigDecimal price;
    private boolean onSale;
    private BigDecimal discount;


    public Item(String name, BigDecimal price, boolean onSale, BigDecimal discount) {
        this.name = name;
        this.price = price;
        this.onSale = onSale;
        this.discount = discount;
    }

    public Item(String name, BigDecimal price, boolean onSale) {
        this.name = name;
        this.price = price;
        this.onSale = onSale;
        this.discount = BigDecimal.ZERO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

}
