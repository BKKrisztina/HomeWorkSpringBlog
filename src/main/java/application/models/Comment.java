package application.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long commentID;
    @Column(name = "TEXT")
    private String commentText;

    @ManyToOne
    //@Column(name = "COMMENTER")
    private BlogUser commenter;

    @Enumerated
    private Status status;

    @CreationTimestamp
    @Column(name = "CREATED")
    private LocalDateTime creationTime;

    @ManyToOne
    private BlogPost toBlogPost;

    @ManyToOne
    private Comment historyCommentID;


    @OneToMany
    private List<Comment> commentList;

    public Comment() {
    }

    public Comment(long commentID,
                   String commentText,
                   BlogUser commenter,
                   LocalDateTime creationTime,
                   Comment historyCommentID,
                   List<Comment> commentList) {
        this.commentID = commentID;
        this.commentText = commentText;
        this.commenter = commenter;
        this.creationTime = creationTime;
        this.historyCommentID = historyCommentID;
        this.commentList = commentList;
    }

    public long getCommentID() {
        return commentID;
    }

    public void setCommentID(long commentID) {
        this.commentID = commentID;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public BlogUser getCommenter() {
        return commenter;
    }

    public void setCommenter(BlogUser commenter) {
        this.commenter = commenter;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public Comment getHistoryCommentID() {
        return historyCommentID;
    }

    public void setHistoryCommentID(Comment historyCommentID) {
        this.historyCommentID = historyCommentID;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
