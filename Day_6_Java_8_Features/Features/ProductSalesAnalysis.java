import java.util.*;
import java.util.stream.Collectors;

class Sale {
    int productId;
    int quantity;
    double price;

    public Sale(int productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public double getRevenue() {
        return quantity * price;
    }

    public int getProductId() {
        return productId;
    }
}

class ProductSales {
    int productId;
    double totalRevenue;

    public ProductSales(int productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }
}

public class ProductSalesAnalysis {
    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
            new Sale(1, 15, 50),
            new Sale(2, 5, 100),
            new Sale(3, 20, 30),
            new Sale(4, 8, 120)
        );

        List<ProductSales> result = sales.stream()
            .filter(s -> s.quantity > 10)
            .map(s -> new ProductSales(s.getProductId(), s.getRevenue()))
            .sorted((p1, p2) -> Double.compare(p2.totalRevenue, p1.totalRevenue))
            .limit(5)
            .collect(Collectors.toList());

        result.forEach(p -> System.out.println(p.productId + ": " + p.totalRevenue));
    }
}
