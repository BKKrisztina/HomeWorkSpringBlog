package application.controllers;
import application.models.BlogPost;
import application.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/newblogpost", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createblogpost(@RequestBody BlogPost blogPost){
        boolean registered = service.createNewBlogPost(blogPost);
        if (registered){
            return  "ok, well done";
        }
        return "not ok, try harder";
    }
}
