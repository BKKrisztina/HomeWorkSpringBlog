package application.services;
import application.jpaRepos.CommentRepo;
import application.models.Comment;
import application.models.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
@Service
public class CommentService {

    private CommentRepo commentRepo;

    @Autowired
    public CommentService(CommentRepo commentRepo){
        this.commentRepo = commentRepo;

    }

    @Transactional
    public List<Comment> getAllComments() {
        return commentRepo.findAll();
    }
    @Transactional
    public List<Comment> getAllCommentsPerCommenter(String commenter){
        return commentRepo.findCommentsByCommenter_Username(commenter);
    }

    @Transactional
    public boolean createNewComment(Comment comment) {
        try {
            comment.setStatus(Status.PUBLISHED);
            commentRepo.save(comment);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
