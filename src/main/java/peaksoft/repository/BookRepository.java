package peaksoft.repository;

import peaksoft.model.Book;

import java.util.List;

public interface BookRepository {
    void saveBook(Book book);

    List<Book> getAllBooks();

    void assignBookToAuthor(Long authorId, Long bookId);

    List<Book> getAllBooksWithoutAuthor();
}
