package application.services;
import application.jpaRepos.BlogPostRepo;
import application.models.BlogPost;
import application.models.Status;
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

    @Transactional
    public boolean createNewBlogPost(BlogPost blogPost) {
        try {
            blogPost.setStatus(Status.PUBLISHED);
            blogPostRepo.save(blogPost);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

