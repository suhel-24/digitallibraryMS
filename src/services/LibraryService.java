package services;
import models.Book;
import repository.BookRepository;

public class LibraryService {
    private final BookRepository repository;

    public LibraryService(BookRepository repository) {
        this.repository = repository;
    }

    public void updateBook(String id, String title, String author, String availability) {
        Book book = repository.findBook(id);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (!title.isEmpty()) book.setTitle(title);
        if (!author.isEmpty()) book.setAuthor(author);
        if (availability.equalsIgnoreCase("Available") || availability.equalsIgnoreCase("Checked Out")) {
            book.setAvailability(availability);
        }
        System.out.println("Book updated successfully.");
    }
}