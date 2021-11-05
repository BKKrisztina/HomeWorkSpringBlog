package application.jpaRepos;

import application.models.BlogUser;
import application.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, String> {
    List<Comment> findCommentsByCommenter_Username(String commenter);
}
