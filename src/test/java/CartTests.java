
import static org.junit.Assert.*;

import models.Cart;
import models.Item;
import models.LineItem;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CartTests {

    @Test
    public void cartShouldBeEmpty() {
        Cart cart = new Cart();
        int expected = 0;
        int actual = cart.getItemsInCart().size();
        assertEquals("As a customer, if I haven’t put anything into my cart, the cart is empty", 0, actual);
    }

    @Test
    public void itemQuantitiesShouldUpdateAfterAddingProduct() {
        Cart cart = new Cart();
        Item item = new Item("Zara Handbag", new BigDecimal("999"), false);
        //LineItem lineItem = new LineItem(item);
        List<String> expected = Arrays.asList("Item: Zara Handbag quantity: (1) ");
        cart.addItemToCart(item);
        List<String> quantities = cart.itemQuantities();
        int quantity = quantities.size();
        assertEquals("As a customer, I can add a product to the cart, and the cart will display a quantity of 1 of that product, in that line item.", expected, quantities);
        assertEquals("Should show quantity after adding the product", quantity, 1);

    }

    @Test
    public void increaseQuantityByOne() {
        Cart cart = new Cart();
        Item item = new Item("Mochi Shoes", new BigDecimal("999"), false);
        int expected = 2;
        cart.addItemToCart(item);
        cart.increaseQuantityByOne(item);
        List<LineItem> items = cart.getItemsInCart();
        int quantity = items.get(0).getQuantity();
        assertEquals("As a customer, I can increase the quantity of a line item by 1.", expected, quantity);
    }

    @Test
    public void decreaseQuantityByOne() {
        Cart cart = new Cart();
        Item item = new Item("Mochi Shoes", new BigDecimal("999"), false);
        int expected = 1;
        cart.addItemToCart(item);
        cart.increaseQuantityByOne(item);
        cart.decreaseQuantityByOne(item);

        List<LineItem> items = cart.getItemsInCart();
        int quantity = items.get(0).getQuantity();
        assertEquals("As a customer, I can decrease the quantity of a line item by 1.", expected, quantity);
    }

    @Test
    public void decreaseQuantityByOneAndDeleteFromCart() {
        Cart cart = new Cart();
        Item item = new Item("Mochi Shoes", new BigDecimal("999"), false);
        List<LineItem> expected = Arrays.asList();
        cart.addItemToCart(item);
        cart.decreaseQuantityByOne(item);

        List<LineItem> actual = cart.getItemsInCart();
        //int quantity = items.get(0).getQuantity();
        assertEquals("If I decrease it to 0, the line item disappears. List size is 0 ", 0, actual.size());
        assertEquals("If I decrease it to 0, the line item disappears. List is null ", expected, actual);

    }

    @Test
    public void showDiscountedPrice() {
        Cart cart = new Cart();
        Item item = new Item("Mochi Shoes", new BigDecimal("999"), true, BigDecimal.TEN);
        BigDecimal expected = BigDecimal.ZERO;
        cart.addItemToCart(item);
        List<LineItem> actual = cart.getItemsInCart();
        //int quantity = items.get(0).getQuantity();
        assertEquals("As a customer, I can see the discounted price of each line item in my cart", expected, actual.get(0).getDiscountedPrice());
    }

}
