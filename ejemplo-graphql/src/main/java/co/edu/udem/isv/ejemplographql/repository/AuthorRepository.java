package co.edu.udem.isv.ejemplographql.repository;

import co.edu.udem.isv.ejemplographql.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, String> {
}
