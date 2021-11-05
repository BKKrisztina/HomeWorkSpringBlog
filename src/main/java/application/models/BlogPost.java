package application.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long blogPostID;
    @Column(name = "TEXT")
    private String blogPostText;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    //@Column(name = "POSTER")
    private BlogUser poster;

    @CreationTimestamp
    @Column(name = "CREATED")
    private LocalDateTime creationTime;

    @OneToMany(mappedBy = "toBlogPost")
    private List<Comment> commentList;

    public BlogPost() {
        commentList = new ArrayList<>();
    }

    public BlogPost(long blogPostID, String blogPostText, BlogUser poster, LocalDateTime creationTime, List<Comment> commentList) {
        this();
        this.blogPostID = blogPostID;
        this.blogPostText = blogPostText;
        this.poster = poster;
        this.creationTime = creationTime;
        this.commentList = commentList;
    }

    public long getBlogPostID() {
        return blogPostID;
    }

    public void setBlogPostID(long blogPostID) {
        this.blogPostID = blogPostID;
    }

    public String getBlogPostText() {
        return blogPostText;
    }

    public void setBlogPostText(String blogPostText) {
        this.blogPostText = blogPostText;
    }

    public BlogUser getPoster() {
        return poster;
    }

    public void setPoster(BlogUser poster) {
        this.poster = poster;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
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
