package application.jpaRepos;

import application.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogTemplateRepo extends JpaRepository<Blog, String> {
}
