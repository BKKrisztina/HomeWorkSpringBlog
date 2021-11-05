package application.models;
import application.dtos.BlogUserDTO;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class BlogUser implements UserDetails {

    @Id
    @Column(name = "USER")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "E_MAIL")
    private String email;
    @CreationTimestamp
    @Column(name = "REGISTRATION_TIME")
    private LocalDateTime regTime;

    @Column(name = "AUTHORITY")
    @Enumerated(EnumType.STRING)
    private UserRole authority;

    private boolean isLocked;

    @OneToMany(mappedBy = "blogOwner")
    private List<Blog> blogList;

    @OneToMany(mappedBy = "poster")
    private List<BlogPost> blogPostList;

    @OneToMany(mappedBy = "commenter")
    private List<Comment> commentList;

    public BlogUser() {
        blogList = new ArrayList<>();
        blogPostList = new ArrayList<>();
        commentList = new ArrayList<>();
    }

    public BlogUser(
                    String username,
                    String password,
                    String email,
                    LocalDateTime regTime,
                    UserRole authority,
                    boolean isLocked,
                    List<Blog> blogList,
                    List<BlogPost> blogPostList,
                    List<Comment> commentList) {

        this.username = username;
        this.password = password;
        this.email = email;
        this.regTime = regTime;
        this.authority = authority;
        this.isLocked = isLocked;
        this.blogList = blogList;
        this.blogPostList = blogPostList;
        this.commentList = commentList;
    }

    public BlogUser(
            String username,
            String password,
            String email,
            UserRole authority) {
        this();
        this.username = username;
        this.password = password;
        this.email = email;
        this.authority = authority;
    }

    public BlogUser(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getRegTime() {
        return regTime;
    }

    public void setRegTime(LocalDateTime regTime) {
        this.regTime = regTime;
    }

    public UserRole getAuthority() {
        return authority;
    }

    public void setAuthority(UserRole authority) {
        this.authority = authority;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }

    public List<BlogPost> getBlogPostList() {
        return blogPostList;
    }

    public void setBlogPostList(List<BlogPost> blogPostList) {
        this.blogPostList = blogPostList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
