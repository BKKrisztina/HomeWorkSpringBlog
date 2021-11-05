package application.controllers;

import application.models.Blog;
import application.services.BlogService;
import application.services.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    private BlogService service;
    @Autowired
    public BlogController(BlogService service){this.service = service;}


    @PostMapping(value = "/newblog", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createBlog(@RequestBody Blog blog){
        boolean registered = service.createNewBlog(blog);
        if (registered){
            return  "ok, well done";
        }
        return "not ok, try harder";
    }

    @GetMapping("/blogs")
    public @ResponseBody
    List<Blog> getAllBlogs(){return service.getAllBlogs();}

    @GetMapping("/blogs/{username}")
    public @ResponseBody List<Blog> getAllBlogPerUser(@PathVariable("username") String blogger){
        return service.getAllBlogsPerUser(blogger);}

}
