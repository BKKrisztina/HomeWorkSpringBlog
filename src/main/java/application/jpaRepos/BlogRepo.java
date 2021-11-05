package application.jpaRepos;
import application.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepo extends JpaRepository<Blog, String> {
    List<Blog> findBlogsByBlogOwner_Username(String owner);

}
