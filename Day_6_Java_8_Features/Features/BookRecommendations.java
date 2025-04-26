import java.util.*;
import java.util.stream.Collectors;

class Book {
    String title;
    String author;
    String genre;
    double rating;

    public Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }
}

class BookRecommendation {
    String title;
    double rating;

    public BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }
}

public class BookRecommendations {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Dune", "Frank Herbert", "Science Fiction", 4.8),
            new Book("1984", "George Orwell", "Dystopia", 4.5),
            new Book("Ender's Game", "Orson Scott Card", "Science Fiction", 4.6),
            new Book("Fahrenheit 451", "Ray Bradbury", "Dystopia", 4.3)
        );

        List<BookRecommendation> result = books.stream()
            .filter(b -> b.getGenre().equals("Science Fiction") && b.getRating() > 4.0)
            .map(b -> new BookRecommendation(b.getTitle(), b.getRating()))
            .sorted((b1, b2) -> Double.compare(b2.rating, b1.rating))
            .limit(10)
            .collect(Collectors.toList());

        result.forEach(b -> System.out.println(b.title + ": " + b.rating));
    }
}
