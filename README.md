
# Digital Library Book Management System

This is a Digital Library Book Management System built using Java. It allows librarians to efficiently manage books by adding, updating, searching, and removing records while maintaining their availability status.


## Features

- Add Book – Register a new book with ID, title, author, genre, and availability.

- View All Books – Display all books with details.

- Search Book – Search by ID or title.

- Update Book – Modify book details (title, author, availability).

- Delete Book – Remove a book from the library.

- Exit System – Close the application.


## Run Locally

Clone the project

```bash
  git clone https://github.com/suhel-24/digitallibraryMS.git
```


Start the server

Run the Main.java file



## Implementation Details


- Book.java (Model): Represents a book entity with attributes.

- BookRepository.java (Repository): Manages storage and retrieval of books.

- LibraryService.java (Service): Handles business logic and operations.

- Main.java: Provides a command-line interface for user interactions.



## Exception Handling & Validations

- Ensures unique Book IDs to prevent duplicates.

- Validates non-empty title and author fields.

- Restricts availability to "Available" or "Checked Out".

- Handles invalid user input with appropriate messages.

