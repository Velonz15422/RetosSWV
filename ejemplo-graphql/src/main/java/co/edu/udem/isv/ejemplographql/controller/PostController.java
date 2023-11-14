package co.edu.udem.isv.ejemplographql.controller;

import co.edu.udem.isv.ejemplographql.dao.AuthorDao;
import co.edu.udem.isv.ejemplographql.dao.PostDao;
import co.edu.udem.isv.ejemplographql.model.Author;
import co.edu.udem.isv.ejemplographql.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.GraphQlClientException;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class PostController {

    private final PostDao postDao;
    private final AuthorDao authorDao;

    @Autowired
    public PostController(PostDao postDao, AuthorDao authorDao) {
        this.postDao = postDao;
        this.authorDao = authorDao;
    }



    @SchemaMapping(typeName = "Post", field = "author")
    public Optional<Author> getAuthor(Post post) {
        return authorDao.getAuthor(post.getAuthorId());
    }

    @MutationMapping
    public Post createPost(@Argument String title, @Argument String text,
                           @Argument String category, @Argument String authorId) {

        if (authorDao.getAuthor(authorId).isEmpty()) {
            throw new RuntimeException("No author found");
        }

        Post post = new Post();
        post.setId(UUID.randomUUID().toString());
        post.setTitle(title);
        post.setText(text);
        post.setCategory(category);
        post.setAuthorId(authorId);

        postDao.savePost(post);

        return post;
    }

    @MutationMapping
    public Author createAuthor(@Argument String name, @Argument String thumbnail) {
        Author author = new Author();
        author.setId(UUID.randomUUID().toString());
        author.setName(name);
        author.setThumbnail(thumbnail);

        authorDao.saveAuthor(author);

        return author;
    }

}
