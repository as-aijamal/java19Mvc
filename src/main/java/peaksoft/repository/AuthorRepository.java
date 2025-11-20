package peaksoft.repository;

import peaksoft.model.Author;

import java.util.List;

public interface AuthorRepository {
    void saveAuthor(Author author);

    List<Author> getAllAuthors();

    Author getAuthorById(Long id);

    void updateAuthor(Long id, Author author);

    void deleteAuthor(Long id);
}
