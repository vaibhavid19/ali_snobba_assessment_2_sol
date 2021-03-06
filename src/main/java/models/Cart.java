package models;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Cart {
    private List<LineItem> items = new ArrayList<>();


    public void addItemToCart(Item item) {
        items.add(new LineItem(item));
    }

    public void increaseQuantityByOne(Item item) {
        Optional<LineItem> lineItem = items.stream().filter(i -> i.getItem().getName().equals(item.getName())).findFirst();
        lineItem.get().setQuantity(lineItem.get().getQuantity()+1);
    }

    public void decreaseQuantityByOne(Item item) {
        Optional<LineItem> lineItemOptional = items.stream().filter(i -> i.getItem().getName().equals(item.getName())).findFirst();
        LineItem lineItem = lineItemOptional.get();
        int index=0;
        if (lineItem.getQuantity()==1) {
            for (LineItem lineItemEach : items) {
                if (lineItem.getItem().getName().equals(lineItemEach.getItem().getName())) {
                    //remove
                    index=items.indexOf(lineItemEach);
                }
            }
            items.remove(index);
        } else {
            lineItem.setQuantity(lineItem.getQuantity()-1);
        }
    }

    public List<LineItem> getItemsInCart() {
        return items;
    }

    public List<String> itemQuantities() {
        List<String> lineItems = new ArrayList<>();
        return items.stream()
                .map((item) -> String.format("Item: %s quantity: (%s) ", item.getItem().getName(), item.getQuantity()))
                .collect(Collectors.toList());
    }

}
