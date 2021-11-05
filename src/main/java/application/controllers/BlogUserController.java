package application.controllers;
import application.models.BlogUser;
import application.services.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogUserController {

    private BlogUserService service;

    @Autowired
    public BlogUserController(BlogUserService service){this.service = service;}

    @GetMapping(value = {"/","/home"})
    public String getHello(){return "HelloBelloCsokisLeo";}

    @GetMapping("/user")
    public BlogUser getLoggedInUser(){return service.getLoggedInUser();}

    @GetMapping("/users")
    public List<BlogUser> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping(value = {"/user/{username}"})
    public @ResponseBody BlogUser getOneBlogUser(
            @PathVariable("username") String username
    ) {
        if (username != null) {
            return service.getOneBlogUser(username);
        }
        return null;
    }

    @GetMapping(value = {"/loginsuccess/{username}"})
    public String welcomeBlogUser(@PathVariable("username") String username){
        String blogger = String.valueOf(service.getOneBlogUser(username).getUsername());
        String email = String.valueOf(service.getOneBlogUser(username).getEmail());
        return "Welcome " + blogger + "!" +"\r\n"+ "Your registered e-mail address is: "
                + email + "\r\n";    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String registerUser(@RequestBody BlogUser user){
        boolean registered = service.registerUsers(user);
        if (registered){
            return  "ok, well done";
        }
        return "not ok, try harder";
    }

}
