package application.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class BlogTemplate {

    @Id
    private String blogTemplateName;

    @ManyToOne
    private BlogUser creator;

    @CreationTimestamp
    private LocalDateTime creationTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "FONT_COLOUR")
    private FontColour fontcolour;

    @Enumerated(EnumType.STRING)
    @Column(name = "FONT_TYPE")
    private FontType fontType;

    @OneToMany(mappedBy = "blogTemplateName")
    private List<Blog> blogList;

    public BlogTemplate() {
    }

    public BlogTemplate(String blogTemplateName,
                        BlogUser creator,
                        LocalDateTime creationTime,
                        FontColour fontcolour,
                        FontType fontType,
                        List<Blog> blogList) {
        this.blogTemplateName = blogTemplateName;
        this.creator = creator;
        this.creationTime = creationTime;
        this.fontcolour = fontcolour;
        this.fontType = fontType;
        this.blogList = blogList;
    }

    public String getBlogTemplateName() {
        return blogTemplateName;
    }

    public void setBlogTemplateName(String blogTemplateName) {
        this.blogTemplateName = blogTemplateName;
    }

    public BlogUser getCreator() {
        return creator;
    }

    public void setCreator(BlogUser creator) {
        this.creator = creator;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public FontColour getFontcolour() {
        return fontcolour;
    }

    public void setFontcolour(FontColour fontcolour) {
        this.fontcolour = fontcolour;
    }

    public FontType getFontType() {
        return fontType;
    }

    public void setFontType(FontType fontType) {
        this.fontType = fontType;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}
