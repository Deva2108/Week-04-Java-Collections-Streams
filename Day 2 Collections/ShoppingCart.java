import java.util.*;

public class ShoppingCart {

    private Map<String, Double> priceMap;              // HashMap for product prices
    private LinkedHashMap<String, Integer> cart;       // Maintains order of items added

    public ShoppingCart() {
        priceMap = new HashMap<>();
        cart = new LinkedHashMap<>();
    }

    // Add product and price to catalog
    public void addProduct(String product, double price) {
        priceMap.put(product, price);
    }

    // Add item to cart (adds 1 quantity at a time)
    public void addToCart(String product) {
        if (!priceMap.containsKey(product)) {
            System.out.println("Product not found: " + product);
            return;
        }
        cart.put(product, cart.getOrDefault(product, 0) + 1);
    }

    // Display items in cart in the order they were added
    public void displayCartOrder() {
        System.out.println("Cart Items (Insertion Order):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            double price = priceMap.get(product);
            System.out.printf("%s x%d -> $%.2f each%n", product, quantity, price);
        }
    }

    // Display items sorted by price using TreeMap
    public void displayCartSortedByPrice() {
        System.out.println("Cart Items Sorted by Price:");

        TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>();

        for (String product : cart.keySet()) {
            double price = priceMap.get(product);
            sortedByPrice.putIfAbsent(price, new ArrayList<>());
            sortedByPrice.get(price).add(product);
        }

        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            double price = entry.getKey();
            for (String product : entry.getValue()) {
                int quantity = cart.get(product);
                System.out.printf("%s x%d -> $%.2f each%n", product, quantity, price);
            }
        }
    }

    // Main method to simulate shopping
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Add products
        cart.addProduct("Apple", 0.99);
        cart.addProduct("Banana", 0.59);
        cart.addProduct("Milk", 1.99);
        cart.addProduct("Bread", 2.49);
        cart.addProduct("Eggs", 2.49);  // Same price as Bread

        // Add to cart
        cart.addToCart("Milk");
        cart.addToCart("Banana");
        cart.addToCart("Apple");
        cart.addToCart("Bread");
        cart.addToCart("Eggs");
        cart.addToCart("Apple");

        cart.displayCartOrder();
        System.out.println();
        cart.displayCartSortedByPrice();
    }
}
