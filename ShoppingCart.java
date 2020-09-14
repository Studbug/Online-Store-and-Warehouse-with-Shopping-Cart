
import java.util.*;

public class ShoppingCart {

    private List<Item> itemsInCart;

    public ShoppingCart() {
        this.itemsInCart = new ArrayList<>();
    }

    public void add(String product, int price) {
        Item item = new Item(product, 1, price);
        if (this.itemsInCart.contains(item)) {
            this.itemsInCart.get(this.itemsInCart.indexOf(item)).increaseQuantity();
        } else {
            this.itemsInCart.add(item);
        }
    }

    public int price() {
        int totalPrice = 0;
        for (Item product : this.itemsInCart) {
            totalPrice += product.price();
        }
        return totalPrice;
    }

    public void print() {
        for (Item product : this.itemsInCart) {
            System.out.println(product);
        }
    }
}
