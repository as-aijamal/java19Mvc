package peaksoft.service;

import peaksoft.model.Author;

import java.util.List;

public interface AuthorService {
    void saveAuthor(Author author);

    List<Author> getAllAuthors();

    Author getAuthorById(Long id);

    void updateAuthor(Long id, Author author);

    void deleteAuthor(Long id);
}
