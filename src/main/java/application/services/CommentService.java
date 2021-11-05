package application.services;

import application.jpaRepos.BlogUserRepo;
import application.jpaRepos.CommentRepo;
import application.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    public List<Comment> getAllCommentsPerCommenter(String commenter){
        return commentRepo.findCommentsByCommenter_Username(commenter);
    }
}
