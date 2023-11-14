package co.edu.udem.isv.ejemplographql.dao;

import co.edu.udem.isv.ejemplographql.model.Post;
import co.edu.udem.isv.ejemplographql.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostDao {
    private final PostRepository postRepository;

    @Autowired
    public PostDao(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void savePost(Post post) {
        postRepository.save(post);
    }


}
