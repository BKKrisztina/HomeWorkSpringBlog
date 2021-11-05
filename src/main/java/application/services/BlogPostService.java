package application.services;

import application.jpaRepos.BlogPostRepo;
import application.jpaRepos.BlogRepo;
import application.models.Blog;
import application.models.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class BlogPostService {

    private BlogPostRepo blogPostRepo;

    @Autowired
    public BlogPostService(BlogPostRepo blogRepo) {
        this.blogPostRepo = blogRepo;
    }
    @Transactional
    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepo.findAll();
    }

    @Transactional
    public List<BlogPost> getAllBlogPostsPerUser(String poster) {
        return blogPostRepo.findAllByPoster(poster);
    }
}

