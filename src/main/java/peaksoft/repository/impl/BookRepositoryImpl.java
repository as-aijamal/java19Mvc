package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import peaksoft.model.Author;
import peaksoft.model.Book;
import peaksoft.repository.BookRepository;

import java.util.List;

@Repository
@Transactional
public class BookRepositoryImpl implements BookRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return entityManager.createQuery("select b from Book b", Book.class).getResultList();
    }

    @Override
    public void assignBookToAuthor(Long authorId, Long bookId) {
        Author author = entityManager.find(Author.class, authorId);
        Book book = entityManager.find(Book.class, bookId);
        book.setAuthor(author);
        author.getBooks().add(book);
    }

    @Override
    public List<Book> getAllBooksWithoutAuthor() {
        return entityManager.createQuery("select b from Book b where b.author is null", Book.class).getResultList();
    }
}
