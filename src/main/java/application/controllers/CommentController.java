package application.controllers;
import application.models.Comment;
import application.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    private CommentService service;
    @Autowired
    public CommentController(CommentService service){this.service = service;}

    @PostMapping(value = "/newcomment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createComment(@RequestBody Comment comment){
        boolean registered = service.createNewComment(comment);
        if (registered){
            return  "ok, well done";
        }
        return "not ok, try harder";
    }

    @GetMapping("/blogs")
    public @ResponseBody
    List<Comment> getAllComments(){return service.getAllComments();}

    @GetMapping("/blogs/{username}")
    public @ResponseBody List<Comment> getAllBlogPerUser(@PathVariable("username") String commenter){
        return service.getAllCommentsPerCommenter(commenter);}
}
