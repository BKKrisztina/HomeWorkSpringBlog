package application.controllers;
import application.models.BlogPost;
import application.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class BlogPostController {

    private BlogPostService service;
    @Autowired
    public BlogPostController(BlogPostService service){this.service = service;}

    @GetMapping("/blogposts")
    public @ResponseBody
    List<BlogPost> getAllBlogPosts(){return service.getAllBlogPosts();}

    @GetMapping("/blogposts/{username}")
    public @ResponseBody List<BlogPost> getAllBlogPerUser(@PathVariable("username") String poster){
        return service.getAllBlogPostsPerUser(poster);}

}
