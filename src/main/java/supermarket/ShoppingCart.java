package supermarket;

import supermarket.products.Product;

import java.util.HashMap;

public class ShoppingCart {
    private int shoppingCart_ID;
    private HashMap<Integer, String> cart = new HashMap<Integer, String>();
    int total_products;
    double total_price;
    Product product;

    public ShoppingCart() {
        Product product1 = new Product("Soap", 6, 1, 8954885);
        total_products = product1.quantity;
        total_price = product1.getPrice();
        addProduct(product1);
        Product product2 = new Product("Cereals", 2.50, 2, 8954873);
        total_products = total_products + product2.quantity;
        total_price = total_price + product2.getPrice();
        addProduct(product2);
    }
    public HashMap<Integer, String> getOrder() {
        return cart;
    }
    public int getOrderSize() {
        return cart.size();
    }

    public int addProduct(Product product) {
        cart.put(product.getEAN(), product.getProduct_name());
        return total_products;
    }

    public int removeProduct(Product product) {
        cart.remove(product.getEAN());
        product.setQuantity(product.quantity--);

        return product.quantity;
    }


    public void showUniqueProducts() {
        System.out.println("Unique products: " + getOrder().values());
        System.out.println("Amount of unique products: " + getOrderSize());
    }

    public void showTotalProducts() {
        System.out.println("Total products: " + total_products);
    }


    public double calculatePriceofTotal() {
        return total_price;
    }
}
