package application.models;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "BLOG")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long blogID;

    @Column(name = "TEMPLATE", nullable = false, unique = true, length = 50)
    private String blogTemplateName;

    @Column(name = "TEXT", length = 10000)
    private String blogText;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    //@Column(name = "OWNER")
    private BlogUser blogOwner;

    @CreationTimestamp
    @Column(name = "CREATED")
    private LocalDateTime creationTime;


    @OneToMany(mappedBy = "blogPostID")
    private List<BlogPost> blogPostList;

  public Blog() {
        blogPostList = new ArrayList<>();
    }

    public Blog(String blogTemplateName, String blogText, BlogUser blogOwner, Status status) {
         this();
         this.blogID = blogID;
         this.blogTemplateName = blogTemplateName;
         this.blogText = blogText;
         this.blogOwner = blogOwner;
         this.creationTime = creationTime;
         this.status = status;
     }
    public Blog(String blogTemplateName, String blogText, BlogUser blogOwner) {

        this.blogTemplateName = blogTemplateName;
        this.blogText = blogText;
        this.blogOwner = blogOwner;
    }

    public Blog(long blogID, String blogTemplateName, String blogText, Status status, BlogUser blogOwner, LocalDateTime creationTime, List<BlogPost> blogPostList) {
        this.blogID = blogID;
        this.blogTemplateName = blogTemplateName;
        this.blogText = blogText;
        this.status = status;
        this.blogOwner = blogOwner;
        this.creationTime = creationTime;
        this.blogPostList = blogPostList;
    }

    public long getBlogID() {
        return blogID;
    }

    public void setBlogID(long blogID) {
        this.blogID = blogID;
    }

    public String getBlogTemplateName() {
        return blogTemplateName;
    }

    public void setBlogTemplateName(String blogTemplateName) {
        this.blogTemplateName = blogTemplateName;
    }

    public String getBlogText() {
        return blogText;
    }

    public void setBlogText(String blogText) {
        this.blogText = blogText;
    }

    public BlogUser getBlogOwner() {
        return blogOwner;
    }

    public void setBlogOwner(BlogUser blogOwner) {
        this.blogOwner = blogOwner;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
