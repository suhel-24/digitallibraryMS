package ui;
import models.Book;
import repository.BookRepository;
import services.LibraryService;
import java.util.Scanner;

public class LibraryCLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookRepository bookRepository = new BookRepository();
        LibraryService libraryService = new LibraryService(bookRepository);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter Availability (Available/Checked Out): ");
                    String availability = scanner.nextLine();
                    bookRepository.addBook(new Book(id, title, author, genre, availability));
                    break;
                case 2:
                    bookRepository.getAllBooks().forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Enter Book ID or Title: ");
                    String query = scanner.nextLine();
                    Book foundBook = bookRepository.findBook(query);
                    System.out.println(foundBook != null ? foundBook : "Book not found.");
                    break;
                case 4:
                    System.out.print("Enter Book ID to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter new Title (leave blank to keep unchanged): ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new Author (leave blank to keep unchanged): ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter new Availability (Available/Checked Out, leave blank to keep unchanged): ");
                    String newAvailability = scanner.nextLine();
                    libraryService.updateBook(updateId, newTitle, newAuthor, newAvailability);
                    break;
                case 5:
                    System.out.print("Enter Book ID to delete: ");
                    String deleteId = scanner.nextLine();
                    bookRepository.removeBook(deleteId);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
