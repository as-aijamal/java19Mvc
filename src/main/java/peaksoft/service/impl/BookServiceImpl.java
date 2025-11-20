package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.model.Book;
import peaksoft.repository.BookRepository;
import peaksoft.service.BookService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public void saveBook(Book book) {
        bookRepository.saveBook(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    @Override
    public void assignBookToAuthor(Long authorId, Long bookId) {
        bookRepository.assignBookToAuthor(authorId, bookId);
    }

    @Override
    public List<Book> getAllBooksWithoutAuthor() {
        return bookRepository.getAllBooksWithoutAuthor();
    }
}
