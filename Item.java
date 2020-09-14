
import java.util.Objects;


public class Item {
    private String product;
    private int qty, unitPrice;
        
    public Item(String product, int qty, int unitPrice) {
        this.product = product;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }
    
    public int price() {
        return this.unitPrice * this.qty;
    }
    
    public int getQuantity() {
        return this.qty;
    }
    
    public void increaseQuantity() {
        this.qty++;
    }
    
    @Override
    public String toString(){
        return this.product + ": " + this.qty;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.product);
        hash = 83 * hash + this.unitPrice;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (this.unitPrice != other.unitPrice) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        return true;
    }
    
}
