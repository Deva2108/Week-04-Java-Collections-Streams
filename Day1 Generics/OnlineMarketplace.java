​​import java.util.*;

interface Category {}

class BookCategory implements Category {}
class ClothingCategory implements Category {}
class GadgetCategory implements Category {}

class Product<T extends Category> {
    String name;
    double price;
    T category;
    Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
}

class Marketplace {
    static <T extends Product<?>> void applyDiscount(T product, double percent) {
        product.price = product.price * (1 - percent / 100);
    }
}

public class OnlineMarketplace {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Book", 500, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 300, new ClothingCategory());

        System.out.println("Before discount: " + book.price);
        Marketplace.applyDiscount(book, 10);
        System.out.println("After discount: " + book.price);

        System.out.println("Before discount: " + shirt.price);
        Marketplace.applyDiscount(shirt, 20);
        System.out.println("After discount: " + shirt.price);
    }
}
