package application.jpaRepos;

import application.models.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogUserRepo extends JpaRepository<BlogUser, String> {
    BlogUser findBlogUserByUsername(String username);

}
