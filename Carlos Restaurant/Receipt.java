import java.util.*;
public class Receipt {
    private double subtotal;
    private double total;

    public Receipt() {
        subtotal = 0.00;
        total = 0.00;
    }

    public void getTotalBill(ArrayList<Item> orderedItems) {
        for (int i = 0; i < orderedItems.size(); i++) {
            double prices = orderedItems.get(i).getPrice();
            subtotal += prices;
        }
        total = subtotal * 1.13;
        System.out.println("Your total is: $" + Math.round(total * 100.0)/100.0);
    }

    public void getSplitBill(ArrayList<Item> orderedItems, int numOfPeople) {
        double splitPrice = 0.00;
        for (int i = 0; i < orderedItems.size(); i++) {
            double prices = orderedItems.get(i).getPrice();
            subtotal += prices;
        }
        splitPrice = (subtotal * 1.13) / numOfPeople;
        System.out.println("With " + numOfPeople + " people, you each pay: $" + Math.round(splitPrice * 100.0)/100.0);
    }
}
