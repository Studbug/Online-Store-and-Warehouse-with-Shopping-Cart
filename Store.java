
import java.util.*;

public class Store {

    private Warehouse warehouse;
    private Scanner scanner;

    public Store(Warehouse warehouse, Scanner scanner) {
        this.warehouse = warehouse;
        this.scanner = scanner;
    }

    // the method that handles the customers visit to the store.
    public void shop(String customer) {
        ShoppingCart cart = new ShoppingCart();
        System.out.println("Welcome to the store " + customer);
        System.out.println("our selection:");

        for (String product : this.warehouse.products()) {
            System.out.println(product);
        }

        while (true) {
            System.out.print("What to put in the cart (press enter to go to the register): ");
            String product = scanner.nextLine();
            if (product.isEmpty()) {
                break;
                //Beginning of my code, all else in this class provided by MOOC.fi
            } else if (warehouse.products().contains(product)) {
                if (warehouse.stock(product) <= 0) {
                    System.out.println("Out of stock.");
                } else {
                    warehouse.take(product);
                    cart.add(product, warehouse.price(product));
                }
            }
                //End of my code
        }

        System.out.println("your shoppingcart contents:");
        cart.print();
        System.out.println("total: " + cart.price());
    }
}
