package supermarket;


import java.util.ArrayList;
import java.util.List;

public class CashRegister {
    double change;
    double total_price;
    double discount;
    Object[] obj;
    List<Object[]> order = new ArrayList<>();
    ShoppingCart shoppingCart;

    public CashRegister() {

    }

    public void checkOut() {
        shoppingCart = new ShoppingCart();
        shoppingCart.showUniqueProducts();
        shoppingCart.showTotalProducts();
        calculateDiscount();
        calculateChange();
    }

    public double calculateDiscount() {

        total_price = shoppingCart.calculatePriceofTotal();
        System.out.println("Price without discount: €" + total_price);

        if(total_price > 10 && total_price <= 20) {
            discount = 0.50;
            System.out.println("Your discount is €0.50");
            total_price = total_price - discount;
        } else if (total_price > 20) {
            discount = 1;
            total_price = total_price - discount;
            System.out.println("Your discount is €1,-");
        }

        System.out.println("You have to pay: €" + total_price);
        return total_price;
    }

    public double calculateChange() {

        return change;
    }

}
