package application.jpaRepos;
import application.models.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BlogPostRepo extends JpaRepository<BlogPost, String> {

    List<BlogPost> findAllByPoster(String poster);
}
