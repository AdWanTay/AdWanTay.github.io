package com.advancedsolutionsdevelopers.ToDoAppBackEnd.network;

import com.advancedsolutionsdevelopers.ToDoAppBackEnd.network.models.ArrayRequest;
import com.advancedsolutionsdevelopers.ToDoAppBackEnd.network.models.SingleItemRequest;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ToDoItemController {
    private final ToDoItemService toDoItemService;
    public ToDoItemController(ToDoItemService toDoItemService) {
        this.toDoItemService = toDoItemService;
    }

    @GetMapping(path = "/")
    public String hello() {
        return "hello";
    }

    @GetMapping(path = "/list")
    public ArrayRequest getTasksList(@RequestHeader("authorization") String authToken) {
        return toDoItemService.getTasksList(authToken);
    }

    @PostMapping(path = "/list")
    public SingleItemRequest addTask(@RequestBody SingleItemRequest itemResponse, @RequestHeader("authorization") String authToken) {
        return toDoItemService.addTask(itemResponse, authToken);
    }

    @DeleteMapping(path = "/list/{id}", produces = APPLICATION_JSON_VALUE)
    public SingleItemRequest deleteTask(@PathVariable String id) {
        return toDoItemService.deleteTask(id);
    }

    @PutMapping(path = "list/{id}")
    public SingleItemRequest updateTask(@RequestHeader("authorization") String authToken, @RequestBody SingleItemRequest request, @RequestHeader("X-Last-Known-Revision") int rev) {
        return toDoItemService.updateTask(authToken, request, rev);
    }
}
