package co.edu.udem.isv.ejemplographql.repository;

import java.util.List;

import co.edu.udem.isv.ejemplographql.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
