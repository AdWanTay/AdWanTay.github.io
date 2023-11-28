package com.advancedsolutionsdevelopers.ToDoAppBackEnd.network;

import com.advancedsolutionsdevelopers.ToDoAppBackEnd.models.ToDoItem;
import com.advancedsolutionsdevelopers.ToDoAppBackEnd.database.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
// This means URL's start with /geek (after Application path)
//@RequestMapping(path = "/list")

public class ToDoItemController {
    @Autowired
    private ToDoItemRepository toDoItemRepository;

    @GetMapping(path = "/list")
    public ResponseEntity<Iterable<ToDoItem>> getTasksList(@RequestHeader("authorization") String authToken) {
        System.out.println(authToken);
        return new ResponseEntity<>(toDoItemRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/list/{id}")
    public ResponseEntity<ToDoItem> getTaskById(@PathVariable long id) {
        Optional<ToDoItem> toDoItem = toDoItemRepository.findById(id);
        return toDoItem.map(doItem -> new ResponseEntity<>(doItem, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));

    }

//    @PatchMapping(path = "/list")
//    public


}
