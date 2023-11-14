package co.edu.udem.isv.ejemplographql.dao;

import co.edu.udem.isv.ejemplographql.model.Author;
import co.edu.udem.isv.ejemplographql.repository.AuthorRepository;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Component
public class AuthorDao {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorDao(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Optional<Author> getAuthor(String id) {
        return authorRepository.findById(id);
    }
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }
}
