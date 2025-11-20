package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.model.Author;
import peaksoft.repository.AuthorRepository;
import peaksoft.service.AuthorService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public void saveAuthor(Author author) {
        authorRepository.saveAuthor(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.getAllAuthors();
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.getAuthorById(id);
    }

    @Override
    public void updateAuthor(Long id, Author author) {
        authorRepository.updateAuthor(id, author);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteAuthor(id);
    }
}
