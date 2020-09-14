
import java.util.*;

public class Warehouse {

    private Map<String, Integer> productPrices;
    private Map<String, Integer> productStocks;

    public Warehouse() {
        this.productPrices = new HashMap<>();
        this.productStocks = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        this.productPrices.put(product, price);
        this.productStocks.put(product, stock);
    }

    public int price(String product) {
        return this.productPrices.getOrDefault(product, -99);
    }

    public int stock(String product) {
        return this.productStocks.getOrDefault(product, 0);
    }

    public boolean take(String product) {
        if (!this.productStocks.containsKey(product)) {
            return false;
        }

        int currentStock = this.productStocks.get(product);
        if (currentStock <= 0) {
            return false;
        }
        currentStock--;
        this.productStocks.put(product, currentStock);
        return true;
    }
    
    public Set<String> products() {
        Set<String> productList = this.productPrices.keySet();
        return productList;
    }
}
