package repository;
import models.Book;
import java.util.*;

public class BookRepository {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        for (Book b : books) {
            if (b.getId().equals(book.getId())) {
                System.out.println("Book ID must be unique.");
                return;
            }
        }
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public List<Book> getAllBooks() { return books; }
    public Book findBook(String query) {
        return books.stream().filter(book -> book.getId().equalsIgnoreCase(query) || book.getTitle().equalsIgnoreCase(query)).findFirst().orElse(null);
    }
    public void removeBook(String id) { books.removeIf(book -> book.getId().equals(id)); }
}