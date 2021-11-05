package application.controllers;

import application.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    private CommentService service;
    @Autowired
    public CommentController(CommentService service){this.service = service;}

}
