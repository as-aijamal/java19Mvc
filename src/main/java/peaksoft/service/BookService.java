package peaksoft.service;

import peaksoft.model.Book;

import java.util.List;

public interface BookService {
    void saveBook(Book book);

    List<Book> getAllBooks();
    void assignBookToAuthor(Long authorId, Long bookId);
    List<Book> getAllBooksWithoutAuthor();
}
