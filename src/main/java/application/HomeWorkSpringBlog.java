package application;

import application.services.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeWorkSpringBlog {

    public static void main(String[] args) {
        SpringApplication.run(HomeWorkSpringBlog.class, args);
       // service.registerUsers();
    }

/*    @Autowired
    HomeWorkSpringBlog(BlogUserService service){HomeWorkSpringBlog.service = service;}

   static BlogUserService service;*/
}
