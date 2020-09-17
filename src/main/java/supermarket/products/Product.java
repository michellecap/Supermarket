package supermarket.products;

public class Product {

    public String product_name;
    public double price;
    public int quantity = 0;
    public int EAN;


    public Product(String name, double price, int quantity, int EAN) {
        this.product_name = name;
        this.price = price;
        this.quantity = quantity;
        this.EAN = EAN;
    }


    public int getEAN() {
        return EAN;
    }

    public void setEAN(int EAN) {
        this.EAN = EAN;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return quantity * price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
