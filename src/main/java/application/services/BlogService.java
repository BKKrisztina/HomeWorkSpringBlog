package application.services;
import application.jpaRepos.BlogRepo;
import application.models.Blog;
import application.models.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class BlogService {

    private BlogRepo blogRepo;

    @Autowired
    public BlogService(BlogRepo blogRepo) {
        this.blogRepo = blogRepo;
    }

    @Transactional
    public boolean createNewBlog(Blog blog) {
        try {
            blog.setStatus(Status.PUBLISHED);
            blogRepo.save(blog);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Transactional
    public List<Blog> getAllBlogs() {
        return blogRepo.findAll();
    }

    @Transactional
    public List<Blog> getAllBlogsPerUser(String blogger) {
        return blogRepo.findBlogsByBlogOwner_Username(blogger);
    }
}