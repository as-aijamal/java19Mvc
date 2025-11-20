package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import peaksoft.model.Author;
import peaksoft.repository.AuthorRepository;

import java.util.List;

@Repository
@Transactional
public class AuthorRepositoryImpl implements AuthorRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveAuthor(Author author) {
        entityManager.persist(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return entityManager.createQuery("select a from Author a", Author.class).getResultList();
    }

    @Override
    public Author getAuthorById(Long id) {
        return entityManager.find(Author.class, id);
    }

    @Override
    public void updateAuthor(Long id, Author author) {
        Author author1 = getAuthorById(id);
        author1.setFirstName(author.getFirstName());
        author1.setLastName(author.getLastName());
        author1.setNationality(author.getNationality());
        entityManager.merge(author1);
    }

    @Override
    public void deleteAuthor(Long id) {
        entityManager.remove(entityManager.find(Author.class, id));
    }
}
