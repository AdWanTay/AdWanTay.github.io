package com.advancedsolutionsdevelopers.ToDoAppBackEnd.network;

import com.advancedsolutionsdevelopers.ToDoAppBackEnd.models.ToDoItem;
import com.advancedsolutionsdevelopers.ToDoAppBackEnd.database.ToDoItemRepository;
import com.advancedsolutionsdevelopers.ToDoAppBackEnd.network.models.ArrayResponse;
import com.advancedsolutionsdevelopers.ToDoAppBackEnd.network.models.SingleItemResponse;
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
public class ToDoItemController {
    @Autowired
    private ToDoItemRepository toDoItemRepository;

    @GetMapping(path = "/list")
    public ArrayResponse getTasksList(@RequestHeader("authorization") String authToken) {
        authToken = authToken.split(" ")[1];
        System.out.printf(authToken);
        ArrayResponse response = new ArrayResponse();
        response.setStatus("200");
        response.setRevision(1);
        response.setList(toDoItemRepository.findAllByAuthor(authToken));
        return response;
    }

//    @GetMapping(path = "/list/{id}")
//    public ResponseEntity<ToDoItem> getTaskById(@PathVariable long id) {
//        Optional<ToDoItem> toDoItem = toDoItemRepository.findById(id);
//        return toDoItem.map(doItem -> new ResponseEntity<>(doItem, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
//
//    }

    @PostMapping(path = "/list")
    public SingleItemResponse addTask(@RequestBody SingleItemResponse itemResponse, @RequestHeader("authorization") String authToken){
        System.out.println(itemResponse.toString());
        ToDoItem toDoItemResponse = itemResponse.getElement();
//        ToDoItem toDoItem = getToDoItem(toDoItemResponse);
        System.out.println(toDoItemResponse);
        toDoItemResponse.setAuthor(authToken.split(" ")[1]);

        toDoItemRepository.save(toDoItemResponse);
        SingleItemResponse response = new SingleItemResponse();
        response.setStatus("200");
        response.setRevision(1);
        response.setElement(toDoItemResponse);
        return response;
    }

//    private static ToDoItem getToDoItem(ToDoItem toDoItemResponse) {
//        ToDoItem toDoItem = new ToDoItem();
//        toDoItem.setAuthor(toDoItemResponse.getAuthor());
//        toDoItem.setImportance(toDoItemResponse.getImportance());
//        toDoItem.setCreated_at(toDoItemResponse.g());
//        toDoItem.setText(toDoItemResponse.getText());
//        toDoItem.setDeadlineDate(toDoItemResponse.getDeadlineDate());
//        toDoItem.setIsCompleted(toDoItemResponse.getIsCompleted());
//        toDoItem.setLastEditDate(toDoItemResponse.getLastEditDate());
//        toDoItem.setLastUpdatedBy(toDoItemResponse.getLastUpdatedBy());
//        return toDoItem;
//    }




}
